package com.github.diogenessantos.apihotel.repository.reserva

import com.github.diogenessantos.apihotel.model.Reserva
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ReservaRepository : JpaRepository<Reserva , Long> {
}