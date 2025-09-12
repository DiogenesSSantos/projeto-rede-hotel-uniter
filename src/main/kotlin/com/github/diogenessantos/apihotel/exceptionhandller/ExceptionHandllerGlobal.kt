package com.github.diogenessantos.apihotel.exceptionhandller

import com.fasterxml.jackson.databind.exc.MismatchedInputException
import com.github.diogenessantos.apihotel.exceptionhandller.exceptionfuncionario.CPFinvalidoException
import com.github.diogenessantos.apihotel.exceptionhandller.exceptionfuncionario.FuncionarioJaCadastroException
import com.github.diogenessantos.apihotel.exceptionhandller.exceptionfuncionario.FuncionarioNaoExisteException
import com.github.diogenessantos.apihotel.exceptionhandller.exceptionhotel.HotelNaoLocalizadoException
import com.github.diogenessantos.apihotel.exceptionhandller.model.CampoInvalidoBeanValidation
import com.github.diogenessantos.apihotel.exceptionhandller.model.Problem
import com.github.diogenessantos.apihotel.exceptionhandller.model.ProblemBeanValidation
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.MissingServletRequestParameterException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.time.LocalDateTime


/**
 * @author DiogenesSSantos
 *
 *classe para captura de exception globalmente
 *
 */
@ControllerAdvice
class ExceptionHandllerGlobal {

    @ExceptionHandler(CPFinvalidoException::class)
    fun handleCPFInvalidadoException(ex: CPFinvalidoException, request: HttpServletRequest): ResponseEntity<Any>? {


        val problem = Problem(
            HttpStatus.BAD_REQUEST.value(), ex.message!!,
            "CPF INVALIDO",
            LocalDateTime.now(),
            CPFinvalidoException::class.toString()
        )

        return ResponseEntity(problem, HttpStatus.BAD_REQUEST)
    }


    @ExceptionHandler(MissingServletRequestParameterException::class)
    fun MissingServletRequestParameterException(ex : MissingServletRequestParameterException ,
                                                request: HttpServletRequest) : ResponseEntity<Any>? {

        val parametoFalho = ex.parameterName

        val problem = Problem(
            HttpStatus.BAD_REQUEST.value(), " O PARAMETRO COM CAMPO [${parametoFalho.uppercase()}] ESTÁ FALHO",
            "ERRO DE PARAMETRO NA REQUISIÇÃO",
            LocalDateTime.now(),
            MissingServletRequestParameterException::class.toString()
        )

        return ResponseEntity(problem, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(HotelNaoLocalizadoException::class)
    fun HotelNaoLocalizadoException(ex : HotelNaoLocalizadoException,
                                    request: HttpServletRequest) : ResponseEntity<Any>? {


        val problem = Problem(
            HttpStatus.BAD_REQUEST.value(), ex.message!!,
            "Dado não existente no banco de dados.",
            LocalDateTime.now(),
            HotelNaoLocalizadoException::class.toString()
        )

        return ResponseEntity(problem, HttpStatus.BAD_REQUEST)
    }


    @ExceptionHandler(FuncionarioNaoExisteException::class)
    fun FuncionarioNaoExisteException(ex : FuncionarioNaoExisteException,
                                    request: HttpServletRequest) : ResponseEntity<Any>? {


        val problem = Problem(
            HttpStatus.BAD_REQUEST.value(), ex.message!!,
            "Dado não existente no banco de dados.",
            LocalDateTime.now(),
            FuncionarioNaoExisteException::class.toString()
        )

        return ResponseEntity(problem, HttpStatus.BAD_REQUEST)
    }



    @ExceptionHandler(FuncionarioJaCadastroException::class)
    fun FuncionarioJaCadastroException(ex : FuncionarioJaCadastroException,
                                    request: HttpServletRequest) : ResponseEntity<Any>? {


        val problem = Problem(
            HttpStatus.BAD_REQUEST.value(), ex.message!!,
            "CPF JÁ CADASTRADO.",
            LocalDateTime.now(),
            FuncionarioJaCadastroException::class.toString()
        )

        return ResponseEntity(problem, HttpStatus.BAD_REQUEST)
    }


    @ExceptionHandler(HttpMessageNotReadableException::class)
    fun HttpMessageNotReadableException(ex : HttpMessageNotReadableException , request: HttpServletRequest) : ResponseEntity<Any?>{

        val cause = ex.cause
        val missingField = if (cause is MismatchedInputException) {
            cause.path.first()
        } else {
            null
        }

        val problem = Problem(
            HttpStatus.BAD_REQUEST.value(),
            "  O campo chamado [${missingField?.fieldName?:"CAMPO VÁZIO"}] " +
                    "não está valido leia a documentação para saber mais detalhes. ",
            "CAMPO INVÁLIDO.",
            LocalDateTime.now(),
            HttpMessageNotReadableException::class.toString()
        )

        return ResponseEntity.ok().body(problem)

    }


    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun MethodArgumentNotValidException(ex: MethodArgumentNotValidException): ResponseEntity<Any?> {
        val errors: List<CampoInvalidoBeanValidation> = ex.bindingResult.fieldErrors.map{ fe ->
            CampoInvalidoBeanValidation(fe.field, fe.defaultMessage ?: "Valor inválido" )
        }

        val problem = ProblemBeanValidation(
            HttpStatus.BAD_REQUEST.value(),
            ex.message!!,
            "CAMPOS INVÁLIDOS.",
            LocalDateTime.now(),
            MethodArgumentNotValidException::class.toString(),
            errors,
        )


        return ResponseEntity.badRequest().body(problem)
    }


}