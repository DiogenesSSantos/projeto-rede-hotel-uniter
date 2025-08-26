package com.github.diogenessantos.apihotel.service

import com.github.diogenessantos.apihotel.controller.request.HotelRequest
import com.github.diogenessantos.apihotel.controller.request.HotelResquetFiltro
import com.github.diogenessantos.apihotel.exceptionhandller.exceptionhotel.HotelNaoLocalizadoException
import com.github.diogenessantos.apihotel.model.Hotel
import com.github.diogenessantos.apihotel.repository.hotel.HotelRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrElse


@Service
class HotelService (private val repository: HotelRepository) {


    @Transactional
    fun buscarPorId (id : Long) : Hotel {
        val hotelLocalizado = repository.findById(id).getOrElse {
            throw HotelNaoLocalizadoException("Hotel com ID[${id}] não existe em nosso banco de dados") }
        return hotelLocalizado

    }

    @Transactional
    fun buscarTodos() : List<Hotel> {
        return repository.findAll()
    }

    @Transactional
    fun salvar(hotel : Hotel) : Hotel {
        return repository.save(hotel)
    }


    @Transactional
    fun atualizarPorCompleto(id : Long , hotelRequest: HotelRequest) : Hotel {
        val hotel = buscarPorId(id)
        apply {
            hotel.nome = hotelRequest.nome
            hotel.endereco = hotelRequest.endereco
            hotel.categoria = hotelRequest.categoria
            hotel.contato = hotelRequest.contato
        }

       return salvar(hotel)
    }

    @Transactional
    fun atualizarParcial(id : Long , hotelRequestFiltro: HotelResquetFiltro) : Hotel {
        val hotel = buscarPorId(id)
        apply {
            hotelRequestFiltro.nome?.let { hotel.nome = it }
            hotelRequestFiltro.endereco?.let { hotel.endereco = it }
            hotelRequestFiltro.categoria?.let { hotel.categoria = it }
            hotelRequestFiltro.contato?.let { hotel.contato = it }
        }

        return salvar(hotel)
    }

    @Transactional
    fun deletar(id : Long) {
        val hotel = repository.findById(id)
        if (hotel.isPresent) {
            apply { repository.delete(hotel.get())}
        }
    }



}