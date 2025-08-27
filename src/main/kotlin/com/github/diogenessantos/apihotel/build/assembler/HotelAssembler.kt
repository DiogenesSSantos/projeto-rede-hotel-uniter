package com.github.diogenessantos.apihotel.build.assembler

import com.github.diogenessantos.apihotel.controller.request.HotelRequest
import com.github.diogenessantos.apihotel.controller.response.HotelFuncionarioResponse
import com.github.diogenessantos.apihotel.controller.response.HotelResponse
import com.github.diogenessantos.apihotel.model.Funcionario
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


    fun toObject(hotelResponse: HotelRequest ): Hotel {
        val hotel : Hotel = hotelResponse.run {
            Hotel(null, this.nome, this.categoria , this.contato,this.endereco)
        }
        return hotel
    }


    fun toHotelFuncionarioResponse(hotel: Hotel , listaFuncionarioHotel : List<Funcionario>) : HotelFuncionarioResponse {
        if (listaFuncionarioHotel.isEmpty()) {
            return HotelFuncionarioResponse("" , emptyList());
        }
        return HotelFuncionarioResponse(hotel.nome , listaFuncionarioHotel)

    }


}