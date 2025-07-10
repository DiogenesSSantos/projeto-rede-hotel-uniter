package com.github.diogenessantos.apihotel.model

import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.springframework.boot.autoconfigure.web.WebProperties

class Hotel (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? ,

    var nome : String,
    var categoria : String,
    var email : String,

    var endereco: Endereco
) {

    constructor(nome : String, categoria: String , email: String , endereco: Endereco ) : this(null,
        nome , categoria,email , endereco){}
}