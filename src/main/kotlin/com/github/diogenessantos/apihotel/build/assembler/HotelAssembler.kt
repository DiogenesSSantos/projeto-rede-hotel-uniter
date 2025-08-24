package com.github.diogenessantos.apihotel.build.assembler

import com.github.diogenessantos.apihotel.controller.response.HotelResponse
import com.github.diogenessantos.apihotel.model.Hotel
import com.github.diogenessantos.apihotel.model.dtos.hotelDTO.HotelDTO
import org.springframework.stereotype.Component

@Component
class HotelAssembler {

        fun toDTO(hotel: Hotel): HotelDTO {
            hotel?.let {

                return HotelDTO(hotel.nome, hotel.categoria, hotel.endereco)
            }
            return HotelDTO(null, null, null)
        }



    fun toResponse(hotel: Hotel) : HotelResponse {
        val hotelResponse : HotelResponse? = hotel?.run {
            HotelResponse(hotel.id!!, hotel.nome, hotel.categoria, hotel.contato, hotel.endereco)
        }
        return hotelResponse!!
    }

}