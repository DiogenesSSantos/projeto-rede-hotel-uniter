package com.github.diogenessantos.apihotel.model

import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.hibernate.validator.constraints.br.CPF

class Reserva (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,

    var idFuncionario: Funcionario,
    var idHospede : Hospede,

) {
}