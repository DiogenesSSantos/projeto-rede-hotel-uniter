package com.github.diogenessantos.apihotel.model

import com.github.diogenessantos.apihotel.validator.MenorDeIdade
import jakarta.persistence.Embedded
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.validator.constraints.br.CPF

@Entity
@Table(name = "tb_hospede")
class Hospede (

    @Id
    @CPF
    val CPF: Long,

    var nome : String,

    @Embedded
    var contato: Contato,


    ) {
}