package com.github.diogenessantos.apihotel.model

import jakarta.persistence.Embeddable


@Embeddable
class Contato(
    var telefone: String,
    var email: String
) {

}