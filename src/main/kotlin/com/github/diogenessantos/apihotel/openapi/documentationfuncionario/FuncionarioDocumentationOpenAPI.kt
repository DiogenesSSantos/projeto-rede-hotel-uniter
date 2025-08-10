package com.github.diogenessantos.apihotel.openapi.documentationfuncionario

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.ExampleObject
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import io.swagger.v3.oas.models.media.Content
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity


@Tag(name = "FUNCIONARIO-CONTROLLER" , description = "End-points disponivél para consumo da api.")
abstract class FuncionarioDocumentationOpenAPI {



    @Operation(summary = "Busca todos funcionarios cadastro na api" )
    @ApiResponse(
       description = "RESPOSTA 200 retornar JSON com todos funcionarios ou vazio [] " , responseCode = "OK" ,
        content = [io.swagger.v3.oas.annotations.media.Content(
            mediaType = "application/json",
            examples = [
                ExampleObject(
                    name  = "SUCESSO",
                    value = FuncionarioConstantExemplo.STATUS_OK
                )
            ]
        )]
    )
    @ApiResponse(
        description = "RESPOSTA 500 ERRO SERVIDOR CONTATE O DESENVOLVEDORES " , responseCode = "ERRO",
        content = [io.swagger.v3.oas.annotations.media.Content(
            mediaType = "application/json",
            examples = [ExampleObject(name = "ERRO" , value = FuncionarioConstantExemplo.STATUS_ERRO) ]
        )]
    )
     abstract fun buscarTodos(@PageableDefault(page = 0 , size = 5 ) pageable: Pageable): ResponseEntity<Any>?







}