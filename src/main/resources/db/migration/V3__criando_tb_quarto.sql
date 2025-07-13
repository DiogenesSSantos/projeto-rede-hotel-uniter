CREATE TABLE tb_quarto (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
    id_hotel BIGINT NOT NULL,
    quantidade_leitos INT NOT NULL,
    tipo VARCHAR(20) NOT NULL,
	status_quarto VARCHAR (50) NOT NULL,
    senha VARCHAR (250) NOT NULL,

    FOREIGN KEY (id_hotel) REFERENCES tb_hotel (id)

);
