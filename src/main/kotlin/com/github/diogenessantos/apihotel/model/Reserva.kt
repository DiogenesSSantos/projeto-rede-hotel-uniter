package com.github.diogenessantos.apihotel.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import org.hibernate.validator.constraints.br.CPF


@Entity
@Table(name = "tb_reserva")
class Reserva(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,


    @ManyToOne
    @JoinColumn(name = "cpf_id_funcionario")
    var idFuncionario: Funcionario,

    @ManyToOne
    @JoinColumn(name = "cpf_id_hospede")
    var idHospede: Hospede,



    @ManyToOne
    @JoinColumn(name = "id_quarto")
    var idQuarto : Quarto

    ) {
}