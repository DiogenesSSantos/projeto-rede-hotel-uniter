package com.github.diogenessantos.apihotel.model

import jakarta.persistence.Id
import org.hibernate.validator.constraints.br.CPF

class Funcionario(
    @Id
    @CPF
    val CPF: Long,

    var nome: String,
    var login: String,
    var senha: String,

    var contato: Contato,
    var endereco: Endereco,

    var idHotel: Hotel
) {


}