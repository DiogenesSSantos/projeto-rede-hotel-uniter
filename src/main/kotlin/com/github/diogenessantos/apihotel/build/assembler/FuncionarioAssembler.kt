package com.github.diogenessantos.apihotel.build.assembler

import com.github.diogenessantos.apihotel.build.model.FuncionarioBuilder
import com.github.diogenessantos.apihotel.controller.request.FuncionarioRequest
import com.github.diogenessantos.apihotel.controller.response.FuncionarioResponse
import com.github.diogenessantos.apihotel.model.Funcionario
import com.github.diogenessantos.apihotel.model.Hotel
import com.github.diogenessantos.apihotel.model.dtos.funcionarioDTO.FuncionarioDTO
import com.github.diogenessantos.apihotel.service.HotelService
import org.springframework.stereotype.Component

@Component
class FuncionarioAssembler(private val hotelService: HotelService ) {

        lateinit  private var hotelAssembler: HotelAssembler


        fun toDto(funcionario : Funcionario) : FuncionarioDTO {

            funcionario?.let {
                return FuncionarioDTO(funcionario.nome, hotelAssembler.toDTO(funcionario.idHotel!!))
            }
            return FuncionarioDTO(null , null)
        }


        fun toModel(funcionarioRequest : FuncionarioRequest) : Funcionario {
            val hotel : Hotel = hotelService.buscarPorId(funcionarioRequest.idHotel!!)

            val funcionarioBuilder = FuncionarioBuilder()
                .cpf(funcionarioRequest.cpf!!)
                .nome(funcionarioRequest.nome!!)
                .contato(funcionarioRequest.contato!!)
                .endereco(funcionarioRequest.endereco!!)
                .hotel(hotel)
                .senha(funcionarioRequest.senha!!)
                .login(funcionarioRequest.login!!)
                .build()

            return funcionarioBuilder

        }


    fun toResponse(funcionario : Funcionario) : FuncionarioResponse {
        val response = FuncionarioResponse(funcionario.CPF , funcionario.nome
            , funcionario.contato , funcionario.endereco)
        return response
    }


    fun listToResponses(listaFuncionario : List<Funcionario>): List<FuncionarioResponse> {
        val listaResponse = listaFuncionario.map { toResponse(it) }
        return listaResponse
    }



}



