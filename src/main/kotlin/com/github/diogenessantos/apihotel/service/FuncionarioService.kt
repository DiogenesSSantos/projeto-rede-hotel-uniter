package com.github.diogenessantos.apihotel.service

import com.github.diogenessantos.apihotel.build.assembler.FuncionarioAssembler
import com.github.diogenessantos.apihotel.controller.request.FuncionarioRequestParcial
import com.github.diogenessantos.apihotel.exceptionhandller.exceptionfuncionario.CPFinvalidoException
import com.github.diogenessantos.apihotel.exceptionhandller.exceptionfuncionario.FuncionarioJaCadastroException
import com.github.diogenessantos.apihotel.exceptionhandller.exceptionfuncionario.FuncionarioNaoExisteException
import com.github.diogenessantos.apihotel.model.Funcionario
import com.github.diogenessantos.apihotel.model.Hotel
import com.github.diogenessantos.apihotel.repository.funcionario.FuncionarioRepository
import jakarta.transaction.Transactional
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service


/**
 * @author
 * Classe service, aonde fica localizada a regra de negocio.
 */


@Service
class FuncionarioService(
    val repository: FuncionarioRepository,
    private val hotelService: HotelService,
    private val funcionarioAssembler: FuncionarioAssembler
) {


    fun buscarTodos(pageable: Pageable): Page<Funcionario?> {
        return repository.findAll(pageable)
    }

    fun buscarPorNome(nome: String, pageable: Pageable): MutableList<Funcionario> {
        val buscarPorNomePageable = repository.buscarPorNome(nome, pageable)
        return buscarPorNomePageable.toList()
    }


    @Transactional
    fun buscarPorCPF(cpf: Long): Funcionario {
        cpf.toString().let { it ->
            if (it.length != 11) {
                throw CPFinvalidoException()
            }
        }
        val funcionario = repository.buscarPorCPF(cpf)
        return funcionario
    }


    @Transactional
    fun salvar(funcionario: Funcionario): Funcionario {
        if (validaSeExiste(funcionario.CPF)) {
            throw FuncionarioJaCadastroException("Funcionario com CPF ${funcionario.CPF} já existe no banco de dados.")
        }
        return repository.save(funcionario)
    }


    @Transactional
    fun atualizacaoCompleta(funcionario: Funcionario): Funcionario {
        if (!validaSeExiste(funcionario.CPF)) {
            throw FuncionarioNaoExisteException(
                "Funcionário com CPF ${funcionario.CPF} " +
                        "não possui cadastrado no sistema."
            )
        }
        return repository.save(funcionario)
    }


    @Transactional
    fun atualizarParcial(cpf: Long, funcionarioRequestParcial: FuncionarioRequestParcial): Funcionario {
        if (!validaSeExiste(cpf)) {
            throw FuncionarioNaoExisteException(
                "Funcionário com CPF ${cpf} " +
                        "não possui cadastrado no sistema."
            )
        }
        val funcionarioCadastrado = buscarPorCPF(cpf)
        funcionarioAssembler.atualizarfuncionarioParcialToModel(funcionarioCadastrado, funcionarioRequestParcial)
        return repository.save(funcionarioCadastrado)
    }

    @Transactional
    fun buscarFuncionarioPorIdHotel(idHotel: Long): List<Funcionario> {
        val hotelLocalizado: Hotel = hotelService.buscarPorId(idHotel)
        val listaFuncionario: List<Funcionario> = repository.buscarPorIdHotel(hotelLocalizado.id!!)
        return listaFuncionario
    }

    @Transactional
    fun atualizarHotel(cpf: Long, idHotel: Long): Funcionario {
        if (validaSeExiste(cpf)) {
            val funcionario = repository.buscarPorCPF(cpf)
            if (funcionario.idHotel!!.id == idHotel) return funcionario
            val hotel = hotelService.buscarPorId(idHotel)
            funcionario.idHotel = hotel
            return repository.save(funcionario)
        } else {
            throw FuncionarioNaoExisteException(
                "Funcionário com CPF ${cpf} " +
                        "não possui cadastrado no sistema.")
        }
    }


    @Transactional
    fun deletar(cpf: Long) {
        if (validaSeExiste(cpf)) {
            repository.deleteById(cpf)
        }
    }


    private fun validaSeExiste(idCPF: Long): Boolean {
        return repository.existsById(idCPF)
    }

}