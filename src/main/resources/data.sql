INSERT INTO tb_usuarios (codigoIdentificado,nome,dataNascimento,email,telefone,celular)
VALUES ('000.000.000-00', 'Joao', '2000-07-07', 'emailTeste', '1345612', '13465');

DROP IF EXISTS tb_usuarios;
CREATE TABLE tb_usuarios
(codigoIdentificado VARCHAR PRIMARY KEY,
dataNascimento TIME,
nome VARCHAR(255),
email VARCHAR(150),
telefone VARCHAR(15),
celular VARCHAR(15));