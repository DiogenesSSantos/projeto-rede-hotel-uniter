CREATE TABLE tb_pagamento(
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
    id_reserva BIGINT NOT NULL,
    data_compra DATETIME NOT NULL,
    valor DECIMAL(15 , 2) NOT NULL,
    status_pagamento VARCHAR (100) NOT NULL,

    FOREIGN KEY (id_reserva) REFERENCES tb_reserva (id)

);