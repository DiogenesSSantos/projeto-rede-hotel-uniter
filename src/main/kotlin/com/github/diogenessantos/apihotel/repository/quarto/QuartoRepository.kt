package com.github.diogenessantos.apihotel.repository.quarto

import com.github.diogenessantos.apihotel.model.Quarto
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface QuartoRepository : JpaRepository<Quarto , Long> , QuartoRepositoryCustom {

    @Query("SELECT q FROM Quarto q JOIN FETCH q.idHotel")
    fun buscarTodos() : List<Quarto>


}
