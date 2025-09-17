package com.github.diogenessantos.apihotel.service

import com.github.diogenessantos.apihotel.model.Quarto
import com.github.diogenessantos.apihotel.repository.quarto.QuartoRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service


@Service
class QuartoService(val repository: QuartoRepository) {


    fun buscarTodos(): List<Quarto> {
        return repository.buscarTodos()
    }

    @Transactional
    fun salvar(quarto : Quarto) : Quarto {
        return repository.save(quarto)
    }

    fun buscarTodosPorIdHotel(idHotel : Long) : List<Quarto> {
        return repository.buscarTodosPorIdHotel(idHotel)
    }

}