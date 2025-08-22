package com.github.diogenessantos.apihotel.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import jakarta.persistence.criteria.Fetch
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
@Table(name = "tb_pagamento")
class Pagamento (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_reserva")
    val idReserva: Reserva,


    @Column (name = "data_compra")
    val data : LocalDateTime,
    var valor : BigDecimal,

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status_pagamento")
    var status : StatusPagamento = StatusPagamento.AGUARDANDO
) {
}