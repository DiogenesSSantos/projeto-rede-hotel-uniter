package com.github.diogenessantos.apihotel.model

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder
import com.fasterxml.jackson.annotation.JsonValue
import jakarta.persistence.Column
import jakarta.persistence.Embedded
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import org.hibernate.annotations.Columns
import org.hibernate.validator.constraints.br.CPF

@Entity
@Table(name = "tb_funcionario")
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

    @ManyToOne
    @JoinColumn(name = "id_hotel")
    var idHotel: Hotel?
) {


}