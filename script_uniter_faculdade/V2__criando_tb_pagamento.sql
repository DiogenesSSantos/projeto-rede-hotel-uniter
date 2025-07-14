CREATE TABLE tb_pagamento(
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
    id_reserva BIGINT NOT NULL,
    data_compra DATETIME NOT NULL,
    valor DECIMAL(15 , 2) NOT NULL,
    status_pagamento VARCHAR (100) NOT NULL,
    
    FOREIGN KEY (id_reserva) REFERENCES tb_reserva (id)

);
SELECT * FROM tb_pagamento;
INSERT INTO tb_pagamento(id_reserva , data_compra, valor, status_pagamento) VALUES (1 , now(), 22.56, 'APROVADO');