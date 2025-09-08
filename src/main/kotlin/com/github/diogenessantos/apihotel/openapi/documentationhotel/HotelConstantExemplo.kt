package com.github.diogenessantos.apihotel.openapi.documentationhotel

class HotelConstantExemplo {
    companion object {
        const val STATUS_OK: String = "[\n" +
                "  {\n" +
                "    \"Hotel\": {\n" +
                "      \"id\": 1,\n" +
                "      \"nome\": \"VC KISABE\",\n" +
                "      \"categoria\": \"LUXO\",\n" +
                "      \"contato\": {\n" +
                "        \"telefone\": \"ALEATORIO@HOTMAIL.COM\",\n" +
                "        \"email\": \"8184768748\"\n" +
                "         },\n" +
                "      \"endereco\": {\n" +
                "        \"estado\": \"PERNAMBUCO\",\n" +
                "        \"cidade\": \"VITORIA DE SANTO ANTAO\",\n" +
                "        \"bairro\": \"CENTRO\",\n" +
                "        \"rua\": \"RUA DA ALEGRIA\"\n" +
                "          }\n" +
                        "}"+
                    "}"+ "," + "{\"OUTROS \" : \"OBJETOS\"}"+
                "]"


        const val STATUS_OK_HOTEL_INDIVIDUAL: String = "[\n" +
                "  {\n" +
                "    \"Hotel\": {\n" +
                "      \"id\": 1,\n" +
                "      \"nome\": \"VC KISABE\",\n" +
                "      \"categoria\": \"LUXO\",\n" +
                "      \"contato\": {\n" +
                "        \"telefone\": \"ALEATORIO@HOTMAIL.COM\",\n" +
                "        \"email\": \"8184768748\"\n" +
                "         },\n" +
                "      \"endereco\": {\n" +
                "        \"estado\": \"PERNAMBUCO\",\n" +
                "        \"cidade\": \"VITORIA DE SANTO ANTAO\",\n" +
                "        \"bairro\": \"CENTRO\",\n" +
                "        \"rua\": \"RUA DA ALEGRIA\"\n" +
                "          }\n" +
                "}"+
                "}"+
                "]"



        const val STATUS_PUT_ATUALIZACAO: String = "[\n" +
                "  {\n" +
                "    \"Hotel\": {\n" +
                "      \"nome\": \"PRENCHA O CAMPO COM TIPO CORRETO\",\n" +
                "      \"categoria\": \"PRENCHA O CAMPO COM TIPO CORRETO\",\n" +
                "      \"contato\": {\n" +
                "        \"telefone\": \"PRENCHA O CAMPO COM TIPO CORRETO\",\n" +
                "        \"email\": \"PRENCHA O CAMPO COM TIPO CORRETO\"\n" +
                "         },\n" +
                "      \"endereco\": {\n" +
                "        \"estado\": \"PRENCHA O CAMPO COM TIPO CORRETO\",\n" +
                "        \"cidade\": \"PRENCHA O CAMPO COM TIPO CORRETO\",\n" +
                "        \"bairro\": \"PRENCHA O CAMPO COM TIPO CORRETO\",\n" +
                "        \"rua\": \"PRENCHA O CAMPO COM TIPO CORRETO\"\n" +
                "          }\n" +
                "}"+
                "}"+
                "]"



        const val STATUS_PATCH_ATUALIZACAO_PARCIAL: String = "{\n"+
                "\"nome\": \"ATUALIZANDO APENAS UM CAMPO, PREENCHA COM TIPO CORRETO\" \n}"




        const val STATUS_BAD_REQUEST = "{\n"+
            " \"status\" : 400,\n"+
            " \"type\" : \"Hotel com ID[444] não existe em nosso banco de dados\",\n"+
            " \"title\": \"Dado não existente no banco de dados.\",\n"+
            " \"details\": \"2025-09-06T16:13:25.947675389\",\n"+
            " \"instance\": \"class com.github.diogenessantos.apihotel.exceptionhandller.exceptionhotel.HotelNaoLocalizadoException\",\n"+
            " \"timestamp\": \"06-09-2025T 16:13:25\" \n }"



        const val STATUS_ERRO: String = "{\n" +
                "  \"status\": 500,\n" +
                "  \"code\": \"PROCESS_FAILURE\",\n" +
                "  \"message\": \"Falha ao processar a requisição\",\n" +
                "  \"timestamp\": \"2025-07-14T17:05:00.123\"\n" +
                "}\n"


    }

}