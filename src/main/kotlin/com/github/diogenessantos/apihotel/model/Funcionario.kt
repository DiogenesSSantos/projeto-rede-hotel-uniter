package com.github.diogenessantos.apihotel.model

import jakarta.persistence.Embedded
import jakarta.persistence.Id
import org.hibernate.validator.constraints.br.CPF

class Funcionario(
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

    var idHotel: Hotel
) {


}