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
