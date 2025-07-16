package com.github.diogenessantos.apihotel.model

import jakarta.persistence.*
import org.hibernate.validator.constraints.br.CPF

@Entity
@Table(name = "tb_funcionario")
class Funcionario (
    @Id
    @CPF
    val CPF: Long,

    var nome: String,
    var login: String,
    var senha: String,

    @Embedded
    var contato: Contato,

    @Embedded
    var endereco: Endereco,

    @ManyToOne
    @JoinColumn(name = "id_hotel")
    var idHotel: Hotel?
) {


}