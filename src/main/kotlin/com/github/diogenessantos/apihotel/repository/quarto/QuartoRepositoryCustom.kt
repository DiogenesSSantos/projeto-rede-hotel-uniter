package com.github.diogenessantos.apihotel.repository.quarto

import com.github.diogenessantos.apihotel.model.Quarto
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface QuartoRepositoryCustom {
    fun buscarTodosPorIdHotel(idHotel : Long): List<Quarto>
}