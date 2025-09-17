package com.github.diogenessantos.apihotel.build.assembler

import com.github.diogenessantos.apihotel.controller.response.quartoresponses.QuartoRequest
import com.github.diogenessantos.apihotel.controller.response.quartoresponses.QuartoResponse
import com.github.diogenessantos.apihotel.model.Hotel
import com.github.diogenessantos.apihotel.model.Quarto
import com.github.diogenessantos.apihotel.model.StatusQuarto
import com.github.diogenessantos.apihotel.service.HotelService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class QuartoAssembler (private val hotelService : HotelService){



        fun modelToResponse(quartoModel : Quarto) : QuartoResponse {

            return QuartoResponse(quartoModel.quantidadeLeitos,quartoModel.tipo ,
                quartoModel.status ,
                quartoModel.idHotel.nome )
        }

        fun modelToListResponse(quartoModel: List<Quarto>) : List<QuartoResponse> {
            return quartoModel.map { modelToResponse(it) }
        }

            //todo performace pode ser impactada modelTolistResponse cada chamada faz uma consulta, isso pode ser problematico.
        fun requestToModel(quartoRequest: QuartoRequest) : Quarto{
            var hotel : Hotel = hotelService.buscarPorId(quartoRequest.idHotel!!)

            return Quarto(null, quartoRequest.quantidadeLeitos!!, quartoRequest.tipo!! , StatusQuarto.DISPONIVEL , quartoRequest.senha!! , hotel)
        }


}



