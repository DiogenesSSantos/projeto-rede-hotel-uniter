package com.github.diogenessantos.apihotel.openapi.documentationfuncionario

class FuncionarioConstantExemplo {
    companion object {
        const val STATUS_OK: String = "[\n" +

                "  {\n" +
                "    \"nome\": \"DIOGNES\",\n" +
                "    \"login\": \"diobotnex\",\n" +
                "    \"senha\": \"123\",\n" +
                "    \"contato\": {\n" +
                "      \"telefone\": \"84768748\",\n" +
                "      \"email\": \"diogene@hotmail.com\"\n" +
                "    },\n" +
                "    \"endereco\": {\n" +
                "      \"estado\": \"Pernambuco\",\n" +
                "      \"cidade\": \"Vitoria de santo antao\",\n" +
                "      \"bairro\": \"Alto da balanca\",\n" +
                "      \"rua\": \"rua da alegria\"\n" +
                "    },\n" +
                "    \"idHotel\": {\n" +
                "      \"id\": 1,\n" +
                "      \"nome\": \"VC KISABE\",\n" +
                "      \"categoria\": \"LUXO\",\n" +
                "      \"contato\": {\n" +
                "        \"telefone\": \"ALEATORIO@HOTMAIL.COM\",\n" +
                "        \"email\": \"8184768748\"\n" +
                "      },\n" +
                "      \"endereco\": {\n" +
                "        \"estado\": \"PERNAMBUCO\",\n" +
                "        \"cidade\": \"VITORIA DE SANTO ANTAO\",\n" +
                "        \"bairro\": \"CENTRO\",\n" +
                "        \"rua\": \"RUA DA ALEGRIA\"\n" +
                "      }\n" +
                "    },\n" +
                "    \"cpf\": 12485879443\n" +
                "  }\n" +
                "]"


    const val STATUS_ERRO: String = "{\n" +
                "  \"status\": 500,\n" +
                "  \"code\": \"PROCESS_FAILURE\",\n" +
                "  \"message\": \"Falha ao processar a requisição\",\n" +
                "  \"timestamp\": \"2025-07-14T17:05:00.123\"\n" +
                "}\n"





    }

}