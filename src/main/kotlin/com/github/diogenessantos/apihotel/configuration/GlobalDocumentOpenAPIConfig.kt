package com.github.diogenessantos.apihotel.configuration

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Contact
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.info.License
import org.springdoc.core.models.GroupedOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * Classe para configuração do OpenApi
 * @author DiogenesSSantos
 * @since 1.0
 */

@Configuration
class GlobalDocumentOpenAPIConfig {


    @Bean
    fun openAPI(): OpenAPI {

        return OpenAPI()
            .info(
                Info()
                    .title("Hotel-uniter")
                    .description("Projeto hotel uniter, desenvolvido usando a cadeira de banco de dados e MER do trabalho apresentado.")
                    .version("1.0")
                    .contact(
                        Contact()
                            .name("Diogenes da silva santos")
                            .url("https://diogenesssantos.github.io/meu-portfolio/")
                            .email("diogenescontatoofficial@hotmail.com")
                    ).license(License().name("MIT License").url("https://opensource.org/licenses/MIT"))

            )
    }

    @Bean
    fun funcionarioOpenApi(): GroupedOpenApi {
        return GroupedOpenApi
            .builder()
            .group("Funcionario-Controller")
            .pathsToMatch("/funcionario/**")
            .build()
    }


    @Bean
    fun hospedeOpenApi(): GroupedOpenApi {
        return GroupedOpenApi
            .builder()
            .group("Hospede-Controller")
            .pathsToMatch("/hospede/**")
            .build()
    }


    @Bean
    fun hotelOpenApi(): GroupedOpenApi {
        return GroupedOpenApi
            .builder()
            .group("Hotel-Controller")
            .pathsToMatch("/hoteis/**")
            .build()
    }


    @Bean
    fun QuartoOpenApi(): GroupedOpenApi {
        return GroupedOpenApi
            .builder()
            .group("Quarto-Controller")
            .pathsToMatch("/quarto/**")
            .build()
    }

    @Bean
    fun ReservaOpenApi(): GroupedOpenApi {
        return GroupedOpenApi
            .builder()
            .group("Reserva-Controller")
            .pathsToMatch("/reserva/**")
            .build()
    }



    @Bean
    fun pagamentoOpenApi(): GroupedOpenApi {
        return GroupedOpenApi
            .builder()
            .group("Pagamento-Controller")
            .pathsToMatch("/pagamento/**")
            .build()
    }







}