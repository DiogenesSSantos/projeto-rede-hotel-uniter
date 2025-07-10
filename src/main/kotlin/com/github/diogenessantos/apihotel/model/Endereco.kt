package com.github.diogenessantos.apihotel.model

import jakarta.persistence.Embeddable
import jakarta.persistence.Embedded
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Embeddable
class Endereco(
    var estado: String,
    var cidade: String?,
    var bairro: String?,
    var rua: String?
) {
}