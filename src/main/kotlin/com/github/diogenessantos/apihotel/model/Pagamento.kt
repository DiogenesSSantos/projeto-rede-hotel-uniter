package com.github.diogenessantos.apihotel.model

import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.hibernate.validator.constraints.br.CPF
import java.math.BigDecimal
import java.time.LocalDateTime

class Pagamento (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,

    val data : LocalDateTime,
    var valorTotal : BigDecimal,

    @Enumerated
    var status : StatusPagamento = StatusPagamento.AGUARDANDO
) {
}