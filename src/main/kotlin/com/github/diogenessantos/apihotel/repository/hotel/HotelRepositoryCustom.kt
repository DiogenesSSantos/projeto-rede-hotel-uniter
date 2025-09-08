package com.github.diogenessantos.apihotel.repository.hotel

import com.github.diogenessantos.apihotel.model.Funcionario
import com.github.diogenessantos.apihotel.model.Quarto
import org.springframework.stereotype.Repository

@Repository
interface HotelRepositoryCustom {

    abstract fun buscarFuncionarios(id : Long) : List<Funcionario>
    abstract fun buscarTodosQuartos(id : Long) : List<Quarto>
}