CREATE TABLE tb_funcionario(
	cpf BIGINT PRIMARY KEY NOT NULL,
    id_hotel BIGINT  NOT NULL,
    nome VARCHAR (255) NOT NULL,
    login VARCHAR (255) NOT NULL,
    senha VARCHAR (255) NOT NULL,
    telefone VARCHAR (255) NOT NULL,
    email VARCHAR (255) NOT NULL,
	estado VARCHAR (250) NOT NULL,
	cidade VARCHAR (250) NOT NULL,
    bairro VARCHAR (250) NOT NULL,
    rua VARCHAR (250) NOT NULL,
    
    Foreign KEY (id_hotel) REFERENCES tb_hotel(id)
);


INSERT INTO tb_funcionario (cpf ,id_hotel , nome , login , senha, telefone , email, estado , cidade, bairro, rua) 
VALUES ( 12485879443,1 , 'DIOGNES' , 'diobotnex' , '123' , '84768748' , 'diogene@hotmail.com' , 'Pernambuco', 'Vitoria de santo antao' , 'Alto da balanca' , 'rua da alegria');


SELECT * FROM flyway_schema_history;

SELECT f.nome, f.cidade , h.nome as nome_hotel , h.email as email_hotel FROM tb_funcionario f JOIN tb_hotel h;