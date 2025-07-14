CREATE TABLE tb_reserva(
	id BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    cpf_id_funcionario BIGINT NOT NULL,
    cpf_id_hospede BIGINT NOT NULL,
    id_quarto BIGINT NOT NULL

);
