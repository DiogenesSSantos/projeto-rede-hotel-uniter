package com.github.diogenessantos.apihotel.model

import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

class Endereco(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,

    var estado: String,
    var cidade: String?,
    var bairro: String?,
    var rua: String?
) {
}