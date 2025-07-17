package com.github.diogenessantos.apihotel.build.assembler

import com.github.diogenessantos.apihotel.model.Hotel
import com.github.diogenessantos.apihotel.model.dtos.hotelDTO.HotelDTO


class HotelAssembler {


    companion object {

        fun     toDTO(hotel : Hotel) : HotelDTO {
            hotel?.let {

                return HotelDTO(hotel.nome , hotel.categoria , hotel.endereco)
            }
            return HotelDTO(null , null , null)
        }

    }


}