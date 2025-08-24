package com.github.diogenessantos.apihotel.service

import com.github.diogenessantos.apihotel.exceptionhandller.exceptionhotel.HotelNaoLocalizadoException
import com.github.diogenessantos.apihotel.model.Hotel
import com.github.diogenessantos.apihotel.repository.hotel.HotelRepository
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrElse


@Service
class HotelService (private val repository: HotelRepository) {



    fun buscarPorId (id : Long) : Hotel {
        val hotelLocalizado = repository.findById(id).getOrElse {
            throw HotelNaoLocalizadoException("Hotel com ID[${id}] não existe em nosso banco de dados") }
        return hotelLocalizado

    }

    fun buscarTodos() : List<Hotel> {
        return repository.findAll()
    }


}