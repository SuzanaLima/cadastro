package br.com.cadastro_command.service.validation.inclusao.rules;

import br.com.cadastro_command.datacontract.validation.InclusaoUsuario;
import br.com.cadastro_command.exception.GenericException;
import br.com.cadastro_command.service.validation.inclusao.InclusaoRule;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class DigitosVerificadoresCpfValidationRule implements InclusaoRule {

    @Override
    public void valida(InclusaoUsuario inclusaoUsuario) {
        var cpfInformado = inclusaoUsuario.getCpf();
        if(cpfInformado.contains(".") || cpfInformado.contains("-")){
            retiraPontuacaoDoCpf(cpfInformado);
        } else{
            if(!cpfValidador(cpfInformado)){
                throw new GenericException(HttpStatus.UNPROCESSABLE_ENTITY, "CPF inválido");
            }
        }
    }

    private String retiraPontuacaoDoCpf(String cpfInformado){
        if(cpfInformado.contains(".")){
            cpfInformado.replace(".","");
            return cpfInformado;
        } else{
            cpfInformado.replace("-","");
            return cpfInformado;
        }
    }
    private boolean cpfValidador(String cpfInformado){
        if (cpfInformado == null || !cpfInformado.matches("\\d{11}") || cpfInformado.matches("(\\d)\\1{10}")) {
            return false;
        }

        int[] digitos = new int[11];
        for (int i = 0; i < 11; i++) {
            digitos[i] = Character.digit(cpfInformado.charAt(i), 10);
        }

        // Calcula o primeiro dígito verificador
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += digitos[i] * (10 - i);
        }

        int primeiroDigito = 11 - (sum % 11);
        if (primeiroDigito >= 10) {
            primeiroDigito = 0;
        }

        // Verifica o primeiro dígito verificador
        if (digitos[9] != primeiroDigito) {
            return false;
        }

        // Calcula o segundo dígito verificador
        sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += digitos[i] * (11 - i);
        }
        int segundoDigito = 11 - (sum % 11);
        if (segundoDigito >= 10) {
            segundoDigito = 0;
        }

        // Verifica o segundo dígito verificador
        return digitos[10] == segundoDigito;
    }
}
