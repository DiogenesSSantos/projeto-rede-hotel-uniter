package com.github.diogenessantos.apihotel.model

import jakarta.persistence.Embedded
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table


@Entity
@Table(name = "tb_hotel")
class Hotel (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? ,

    var nome : String,
    var categoria : String,

    @Embedded
    var contato: Contato,

    @Embedded
    var endereco: Endereco
) {

    constructor(nome : String, categoria: String, contato: Contato, endereco: Endereco ) : this(null,
        nome , categoria,contato , endereco){}

    override fun toString(): String {
        return "Hotel(id=$id, nome='$nome', categoria='$categoria', contato=$contato, endereco=$endereco)"
    }


}