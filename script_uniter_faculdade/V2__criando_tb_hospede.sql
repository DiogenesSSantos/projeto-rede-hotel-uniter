CREATE TABLE tb_hospede(
	cpf BIGINT PRIMARY KEY NOT NULL,
    nome VARCHAR (255) NOT NULL,
    telefone VARCHAR (50) NOT NULL,
    email VARCHAR (255) NOT NULL
) ;



INSERT INTO tb_hospede (cpf , nome , telefone , email) VALUES ('99999999999' , 'MARIA JOSE' , '8187225456' , 'MARIA@GGAMIL');


SELECT * FROM tb_hospede;

SELECT * FROM flyway_schema_history;