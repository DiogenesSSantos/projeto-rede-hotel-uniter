package com.github.diogenessantos.apihotel.build.assembler

import com.github.diogenessantos.apihotel.build.model.FuncionarioBuilder
import com.github.diogenessantos.apihotel.controller.DTOS.FuncionarioRequestDTO
import com.github.diogenessantos.apihotel.model.Funcionario
import com.github.diogenessantos.apihotel.model.Hotel
import com.github.diogenessantos.apihotel.model.dtos.funcionarioDTO.FuncionarioDTO
import com.github.diogenessantos.apihotel.service.HotelService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class FuncionarioAssembler(private val hotelService: HotelService) {


        fun toDto(funcionario : Funcionario) : FuncionarioDTO {

            funcionario?.let {
                return FuncionarioDTO(funcionario.nome, HotelAssembler.toDTO(funcionario.idHotel!!))
            }
            return FuncionarioDTO(null , null)
        }


        fun toModel(funcionarioRequestDTO : FuncionarioRequestDTO) : Funcionario {
            val hotel : Hotel = hotelService.buscarPorId(funcionarioRequestDTO.idHotel!!)

            val funcionarioBuilder = FuncionarioBuilder()
                .cpf(funcionarioRequestDTO.cpf!!)
                .nome(funcionarioRequestDTO.nome!!)
                .contato(funcionarioRequestDTO.contato!!)
                .endereco(funcionarioRequestDTO.endereco!!)
                .hotel(hotel)
                .senha(funcionarioRequestDTO.senha!!)
                .login(funcionarioRequestDTO.login!!)
                .build()

            return funcionarioBuilder

        }




}



