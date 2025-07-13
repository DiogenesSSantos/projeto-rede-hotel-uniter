package com.github.diogenessantos.apihotel.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table


@Entity
@Table(name = "tb_quarto")
class Quarto (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Long?,

    var quantidadeLeitos : Int,

    var tipo : String,

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status_quarto")
    var status : StatusQuarto = StatusQuarto.DISPONIVEL,

    var senha : Int,


    @ManyToOne
    @JoinColumn(name = "id_hotel")
    var idHotel: Hotel
) {
}