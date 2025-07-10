package com.github.diogenessantos.apihotel.model

import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.hibernate.validator.constraints.br.CPF

class Hospede (

    @Id
    @CPF
    val CPF: Long,

    var nome : String,
    var contato: Contato,
    var endereco: Endereco



    ) {
}