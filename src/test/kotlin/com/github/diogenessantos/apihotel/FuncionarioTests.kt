package com.github.diogenessantos.apihotel

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
import jakarta.persistence.criteria.Expression
import jakarta.persistence.criteria.JoinType
import jakarta.persistence.criteria.Path
import jakarta.persistence.criteria.Predicate
import jakarta.persistence.criteria.Root
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertNotNull
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import kotlin.test.assertEquals


/**
 * @author DiogenesSantos
 *
 * Classe de teste de funcionario
 */

@SpringBootTest
class FuncionarioTests {
    @Autowired
    lateinit var funcionarioService: FuncionarioService

    @Autowired
    lateinit var entityManager: EntityManager


    @Test
    fun salva_funcionario_happy_path() {
        val contato: Contato = Contato("8184768748", "diogenes_bot_nex@gmail.com")
        val endereo: Endereco = Endereco("Pernanmbuco", "Pombos", "Alto da balança", "Rua")


        val jpql = "SELECT h FROM Hotel h WHERE h.id = 1"
        val hotel: Hotel = entityManager.createQuery(jpql, Hotel::class.java).singleResult

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
    fun buscar_por_cpf_happyPath() {
        val cpf = 12485879443
        val funcionarioLocalizado = funcionarioService.buscarPorCPF(cpf)

        assertNotNull(funcionarioLocalizado)
        assertEquals(funcionarioLocalizado.nome, "Diogenes")

//        println(FuncionarioAssembler.toDto(funcionarioLocalizado))

    }


    @Test
    fun buscar_por_cpf_happy_path() {
        val funcionarioLocalizado = funcionarioService.buscarPorCPF(12485879443)

        assertNotNull(funcionarioLocalizado)
        assertEquals(12485879443, funcionarioLocalizado.CPF)

//        println(FuncionarioAssembler.toDto(funcionarioLocalizado))

    }


    /**
     * Se caso o usuário não exista será lançada a exception assim validamos se essa está no sistema
     */
    @Test
    fun buscar_por_cpf_usuario_nao_existe_exception() {
        val exception = assertThrows(
            FuncionarioNaoExisteException::class.java
        ) {
            funcionarioService.buscarPorCPF(12485879450)
        }



        assertEquals(FuncionarioNaoExisteException::class, FuncionarioNaoExisteException::class)

    }


    @Test
    fun buscar_por_cpf_exceptionCPFInvalido_para_null_ou_incorreto() {
        val cpf: Long = 87987564
        assertThrows(FuncionarioNaoExisteException::class.java)
        { funcionarioService.buscarPorCPF(12485879450) }


    }


    @Test
    fun buscar_todos_hoteis_dos_funcionarios_criteriaAPi_happyPath() {
        val criteriaBuilder: CriteriaBuilder = entityManager.criteriaBuilder
        val criteriaQuery: CriteriaQuery<Hotel> = criteriaBuilder.createQuery(Hotel::class.java)
        val root: Root<Funcionario> = criteriaQuery.from(Funcionario::class.java)

        criteriaQuery.select(root.get("idHotel"))


        val TypedQuery: TypedQuery<Hotel> = entityManager.createQuery(criteriaQuery)

        val hoteis: List<Hotel> = TypedQuery.resultList

        println(hoteis)


    }


    @Test
    fun buscar_todos_hoteis_dos_funcionarios_happy_path() {
        val jpql: String = "SELECT f.idHotel FROM Funcionario f"
        val typeQuery: TypedQuery<Hotel> = entityManager.createQuery(jpql, Hotel::class.java)

        val hotelList: List<Hotel> = typeQuery.resultList

        println(hotelList)


    }


    /**
     * Esse teste em especificio usando preojeção de dados, escolhendo atributos especifico, o correto e usar
     * um DTO com os dados que utilizaremos.
     */
    @Test
    fun buscar_hotel_funcionario_happy_path() {
        val jpql: String = "SELECT f.nome AS nome, f.idHotel AS hotel FROM Funcionario f"


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
//            val funcionarioDto = FuncionarioAssembler.toDto(it)
//            println(funcionarioDto)
        }

    }

    @Test
    fun testando_predicates_em_consulta_por_nome() {
        val nome: String = "Di"
        val builder: CriteriaBuilder = entityManager.criteriaBuilder
        val query: CriteriaQuery<Funcionario> = builder.createQuery(Funcionario::class.java)
        val root: Root<Funcionario> = query.from(Funcionario::class.java)
        val join = root.fetch<Funcionario, Hotel>("idHotel", JoinType.INNER)


        var predicates: MutableList<Predicate> = mutableListOf()
        query.select(root)


        if (nome != null) {
            predicates.add(builder.like(root.get("nome"), nome + "%"))
        }

        query.where(*predicates.toTypedArray())


        val typeQuery: TypedQuery<Funcionario> = entityManager.createQuery(query)
        val listaFuncionario: List<Funcionario> = typeQuery.resultList

        println(listaFuncionario)


    }


    @Test
    fun having_metodo_happyPath() {
        val builder: CriteriaBuilder = entityManager.criteriaBuilder
        val queryTupl: CriteriaQuery<Tuple> = builder.createTupleQuery()
        val root: Root<Funcionario> = queryTupl.from(Funcionario::class.java)


        //Usar em contexto aonde deve se aplicar , SUM,COUNT,MIN,MAX,ETC.... Depois dos dados agregado com groupBY!


    }


    @Test
    fun buscar_Funcionarios_Por_Id_Hotel() {
        val idHotel : Long = 2

        val listaFuncionariosHotel : List<Funcionario> = funcionarioService.buscarFuncionarioPorIdHotel(idHotel)

        assertNotNull(listaFuncionariosHotel)
        for (funcionario in listaFuncionariosHotel) {
            println("nome funcionario ${funcionario.nome} || hotel : ${funcionario.idHotel!!.nome}")
        }

    }

}
