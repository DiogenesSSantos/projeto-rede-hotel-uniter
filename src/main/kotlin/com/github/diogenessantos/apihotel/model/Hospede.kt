package com.github.diogenessantos.apihotel.model

import jakarta.persistence.Embedded
import jakarta.persistence.Id
import org.hibernate.validator.constraints.br.CPF

class Hospede (

    @Id
    @CPF
    val CPF: Long,

    var nome : String,

    @Embedded
    var contato: Contato,

    @Embedded
    var endereco: Endereco



    ) {
}