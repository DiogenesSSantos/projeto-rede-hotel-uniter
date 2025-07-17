package com.github.diogenessantos.apihotel.build.assembler

import com.github.diogenessantos.apihotel.build.model.FuncionarioBuilder
import com.github.diogenessantos.apihotel.model.Funcionario
import com.github.diogenessantos.apihotel.model.dtos.funcionarioDTO.FuncionarioDTO
import org.springframework.stereotype.Component

@Component
class FuncionarioAssembler {

    companion object {

        fun toDto(funcionario : Funcionario) : FuncionarioDTO {

            funcionario?.let {
                return FuncionarioDTO(funcionario.nome, HotelAssembler.toDTO(funcionario.idHotel!!))
            }
            return FuncionarioDTO(null , null)
        }


        fun toModel(funcionarioDTO : FuncionarioDTO) : Funcionario? {
            // TODO ainda para implementar, caso necessite ou remova futuramente.
            return null

        }


    }

}



