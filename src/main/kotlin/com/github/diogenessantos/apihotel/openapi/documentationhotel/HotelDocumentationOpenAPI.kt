package com.github.diogenessantos.apihotel.openapi.documentationhotel

import com.github.diogenessantos.apihotel.controller.request.HotelRequest
import com.github.diogenessantos.apihotel.controller.response.hotelresponses.HotelResponse
import com.github.diogenessantos.apihotel.openapi.documentationhotel.HotelConstantExemplo.Companion.STATUS_BAD_REQUEST
import com.github.diogenessantos.apihotel.openapi.documentationhotel.HotelConstantExemplo.Companion.STATUS_ERRO
import com.github.diogenessantos.apihotel.openapi.documentationhotel.HotelConstantExemplo.Companion.STATUS_OK
import com.github.diogenessantos.apihotel.openapi.documentationhotel.HotelConstantExemplo.Companion.STATUS_OK_HOTEL_INDIVIDUAL
import com.github.diogenessantos.apihotel.openapi.documentationhotel.HotelConstantExemplo.Companion.STATUS_PUT_ATUALIZACAO

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.ExampleObject
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody


@Tag(name = "HOTEL-CONTROLLER ", description = "End-points para consumo da API")
abstract class HotelDocumentationOpenAPI {


    @Operation(summary = "Busca todos os hóteis disponível")
    @ApiResponse(
        description = "JSON com todos Hotéis disponivel na api", responseCode = "OK",
        content = [Content(
            mediaType = "application/json",
            examples = [ExampleObject(
                name = "Quando a requisição bem sucedida retornar Json com todos hoteis.",
                value = STATUS_OK
            )]
        )
        ]
    )
    @ApiResponse(
        description = "Error status code 500", responseCode = "ERROR",
        content = [Content(
            mediaType = "application/json",
            examples = [ExampleObject(
                name = "Quando por algum motivo teve error interno do servidor é lançado error 500" +
                        "contate o suporte da API para informações.", value = STATUS_ERRO
            )]
        )
        ]
    )
    abstract fun buscarTodos(): ResponseEntity<List<HotelResponse>>














    @Operation(summary = "Busca o hotel pelo seu ID.")
    @ApiResponse(responseCode = "200", description = "JSON com hotel localizado",
        content = [Content(
            mediaType = "application/json",
            examples = [ExampleObject(name = "Quando a requsição bem sucedida retornar o Hotel" ,
                value = STATUS_OK_HOTEL_INDIVIDUAL)]
        )]
    )
    @ApiResponse(
        description = "Bad request", responseCode = "400",
        content = [Content(
            mediaType = "application/json",
            examples = [ExampleObject(
                name = "Requisição mal sucecidada (Bad request) lança a exception status 400.", value = STATUS_BAD_REQUEST
            )]
        )
        ]
    )
    @ApiResponse(
        description = "Error status code 500", responseCode = "ERROR",
        content = [Content(
            mediaType = "application/json",
            examples = [ExampleObject(
                name = "Quando por algum motivo teve error interno do servidor é lançado error 500" +
                        "contate o suporte da API para informações.", value = STATUS_ERRO
            )]
        )
        ]
    )
    abstract fun buscarPorId(
        @Parameter(description = "ID do hotel", required = true)
        @PathVariable(name = "id") id: Long
    ): ResponseEntity<HotelResponse>











    @Operation(summary = "Atualização por completo hotel.")
        @ApiResponse(responseCode = "200", description = "Retorna o hotel atualizado por completo caso seja bem sucedido",
        content = [Content(
            mediaType = "application/json",
            examples = [ExampleObject(name = "Atualização completa todos so campos (IGNORANDO O ID ) tem que ser preenchido corretamente com seu tipo." ,
                value = STATUS_PUT_ATUALIZACAO)]
        )]
    )
    @ApiResponse(
        description = "Bad request", responseCode = "400",
        content = [Content(
            mediaType = "application/json",
            examples = [ExampleObject(
                name = "Se o hotel para atualização não existir lançará exception.", value = STATUS_BAD_REQUEST
            )]
        )
        ]
    )
    @ApiResponse(
        description = "Error status code 500", responseCode = "ERROR",
        content = [Content(
            mediaType = "application/json",
            examples = [ExampleObject(
                name = "Quando por algum motivo teve error interno do servidor é lançado error 500" +
                        "contate o suporte da API para informações.", value = STATUS_ERRO
            )]
        )
        ]
    )
    abstract  fun atualizar(
        @Parameter(description = "ID do hotel", required = true)
        @PathVariable("id") id: Long,
        @RequestBody hotelRequest: HotelRequest
    ): ResponseEntity<HotelResponse>

}