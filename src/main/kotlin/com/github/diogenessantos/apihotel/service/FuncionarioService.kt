package com.github.diogenessantos.apihotel.service

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
class FuncionarioService (val repository: FuncionarioRepository, private val hotelService: HotelService) {





    fun buscarTodos(pageable: Pageable) : Page<Funcionario?> {
        return repository.findAll(pageable)
    }

    fun buscarPorNome( nome : String , pageable: Pageable ) : MutableList<Funcionario>  {
        val buscarPorNomePageable = repository.buscarPorNome(nome, pageable)
        return buscarPorNomePageable.toList()
    }


    @Transactional
    fun buscarPorCPF (cpf : Long): Funcionario{
        cpf.toString().let { it -> if (it.length != 11) {
                throw CPFinvalidoException()
            }
        }
        val funcionario = repository.buscarPorCPF(cpf)
        return funcionario
    }


    @Transactional
    fun salvar(funcionario : Funcionario) : Funcionario {
        if(validaSeExiste(funcionario.CPF)){
            throw FuncionarioJaCadastroException("Funcionario com CPF ${funcionario.CPF} já existe no banco de dados.")
        }
        return  repository.save(funcionario)
    }


    @Transactional
    fun atualizacaoCompleta( funcionario: Funcionario) : Funcionario {
        if (!validaSeExiste(funcionario.CPF)){
            throw FuncionarioNaoExisteException("Funcionário com CPF ${funcionario.CPF} " +
                    "não possui cadastrado no sistema.")
        }
        return repository.save(funcionario)
    }



    @Transactional
    fun buscarFuncionarioPorIdHotel(idHotel : Long) : List<Funcionario> {
        val hotelLocalizado : Hotel =  hotelService.buscarPorId(idHotel)
        val listaFuncionario : List<Funcionario> = repository.buscarPorIdHotel(hotelLocalizado.id!!)
        return listaFuncionario
    }




    private fun validaSeExiste(idCPF : Long) : Boolean {
        return repository.existsById(idCPF)
    }

}