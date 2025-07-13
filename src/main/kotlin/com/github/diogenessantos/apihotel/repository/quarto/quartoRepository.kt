package com.github.diogenessantos.apihotel.repository.quarto

import com.github.diogenessantos.apihotel.model.Quarto
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface quartoRepository : JpaRepository<Quarto , Long> {
}