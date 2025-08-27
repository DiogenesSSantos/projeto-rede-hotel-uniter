package com.github.diogenessantos.apihotel.repository.hotel

import com.github.diogenessantos.apihotel.model.Funcionario
import org.springframework.stereotype.Repository

@Repository
interface HotelRepositoryCustom {

    abstract fun buscarFuncionariosHotel(id : Long) : List<Funcionario>
}