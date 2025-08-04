package com.github.diogenessantos.apihotel

import com.github.diogenessantos.apihotel.build.assembler.FuncionarioAssembler
import com.github.diogenessantos.apihotel.build.model.FuncionarioBuilder
import com.github.diogenessantos.apihotel.exceptionhandller.exceptionfuncionario.FuncionarioNaoExisteException
import com.github.diogenessantos.apihotel.model.Contato
import com.github.diogenessantos.apihotel.model.Endereco
import com.github.diogenessantos.apihotel.model.Funcionario
import com.github.diogenessantos.apihotel.model.Hotel
import com.github.diogenessantos.apihotel.service.FuncionarioService
import jakarta.persistence.EntityManager
import jakarta.persistence.Tuple
import jakarta.persistence.TypedQuery
import jakarta.persistence.criteria.CriteriaBuilder
import jakarta.persistence.criteria.CriteriaQuery
import jakarta.persistence.criteria.Root
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertNotNull
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.util.Objects
import kotlin.test.assertEquals

@SpringBootTest
class FuncionarioTests {
    @Autowired
    lateinit var funcionarioService: FuncionarioService

    @Autowired
    lateinit var entityManager: EntityManager





    @Test
    fun salva_funcionario_happy_path () {
        val contato : Contato = Contato("8184768748" , "diogenes_bot_nex@gmail.com")
        val endereo : Endereco = Endereco("Pernanmbuco", "Pombos" , "Alto da balança" , "Rua")


        val jpql  = "SELECT h FROM Hotel h WHERE h.id = 1"
        val hotel : Hotel = entityManager.createQuery(jpql, Hotel::class.java).singleResult

        val funcionario = FuncionarioBuilder()
            .cpf(12485879449)
            .hotel(hotel)
            .contato(contato)
            .endereco(endereo)
            .nome("Diogenes")
            .login("DioBotNex")
            .senha("Dio123")
            .build()

        val funcionarioSalvo = funcionarioService.salvar(funcionario)

        assertNotNull(funcionarioSalvo)


    }



    @Test
    fun buscar_todos_hoteis_dos_funcionarios_criteriaAPi_happyPath() {
        val criteriaBuilder : CriteriaBuilder = entityManager.criteriaBuilder
        val criteriaQuery :  CriteriaQuery<Hotel> = criteriaBuilder.createQuery(Hotel::class.java)
        val root : Root<Funcionario> = criteriaQuery.from(Funcionario::class.java)

        criteriaQuery.select(root.get("idHotel"))


        val TypedQuery : TypedQuery<Hotel> = entityManager.createQuery(criteriaQuery)

        val hoteis : List<Hotel> = TypedQuery.resultList

        println(hoteis)





    }



    @Test
    fun buscar_todos_hoteis_cadastrado_happy_path() {
        val jpql : String = "SELECT f.idHotel FROM Funcionario f"
        val typeQuery : TypedQuery<Hotel> = entityManager.createQuery(jpql , Hotel::class.java)

        val hotelList : List<Hotel> = typeQuery.resultList

        println(hotelList)


    }


    @Test
    fun teste_innerJoin () {
        val jpql : String = "SELECT f from Funcionario f " +
                "JOIN  f.idHotel h where h.id = 1"

        val typedQuery : TypedQuery<Funcionario> = entityManager.createQuery(jpql , Funcionario::class.java)

        val listaFuncionario : List<Funcionario> = typedQuery.resultList

        listaFuncionario.forEach { it->
            val funcionarioDto = FuncionarioAssembler.toDto(it)
            println(funcionarioDto)

        }

    }



    @Test
    fun buscar_hotel_funcionario_happy_path () {
        val jpql : String  = "SELECT f.nome AS nome, f.idHotel AS hotel FROM Funcionario f"


        val queryTuple = entityManager.createQuery(jpql, Tuple::class.java)

        val tuples: List<Tuple> = queryTuple.resultList

        for (t in tuples) {
            val nome = t.get("nome", String::class.java)
            val hotel = t.get("hotel", Hotel::class.java)
            println("$nome trabalha em $hotel")
        }


    }






    /**
     * Buscar todos apenas happy path, ja que o retorno quando não existe é mutableList() vazia
     */
    @Test
    fun buscar_todos_happy_path() {
        val funcionarios = funcionarioService.buscarTodos()
        assertNotNull(funcionarios)

        funcionarios.forEach {
            val funcionarioDto = FuncionarioAssembler.toDto(it)
            println(funcionarioDto)
        }

    }


    @Test
    fun buscar_por_cpf_happy_path() {
        val funcionarioLocalizado = funcionarioService.buscarPorCPF(12485879443)

        assertNotNull(funcionarioLocalizado)
        assertEquals(12485879443 , funcionarioLocalizado.CPF)

        println(FuncionarioAssembler.toDto(funcionarioLocalizado))

    }


    /**
     * Se caso o usuário não exista será lançada a exception assim validamos se essa está no sistema
     */
    @Test
    fun buscar_por_cpf_usuario_nao_existe_exception() {
        val exception = assertThrows(
            FuncionarioNaoExisteException::class.java
        ) {
            funcionarioService.buscarPorCPF(12485879443)
        }
        assertEquals(exception::class , FuncionarioNaoExisteException::class)

    }




}