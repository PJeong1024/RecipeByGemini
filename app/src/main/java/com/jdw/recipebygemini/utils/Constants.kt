package com.jdw.recipebygemini.utils

object Constants {
    // https://www.googleapis.com/books/v1/volumes?q=android
    const val BASE_URL = "https://www.googleapis.com/books/v1/"
    const val BASEMENT_TEXT = "Please tell me a dish list you can make with the ingredients below.\n" +
            "The information you need to give is a list of ingredients and a list of cooking steps.\n" +
            "When providing information, it must be provided in JSON format.\n" +
            "Text should be started with {, and ended with }, without any of useless text.\n"+
            "Please refer and follow below JSON format.\n"+
            "\"dish_list\":[\n" +
            "   {\n" +
            "      \"dish_name\":\"Scrambled Eggs with Chorizo\",\n" +
            "      \"ingredients\":[\n" +
            "         {\n" +
            "            \"name\":\"eggs\",\n" +
            "            \"amount\":\"2\"\n" +
            "         },\n" +
            "         {\n" +
            "            \"name\":\"eggs\",\n" +
            "            \"amount\":\"2\"\n" +
            "         }\n" +
            "      ],\n" +
            "      \"steps\":[\n" +
            "         \"Heat the olive oil in a nonstick skillet over medium heat.\",\n" +
            "         \"Heat the olive oil in a nonstick skillet over medium heat.\"\n" +
            "      ]\n" +
            "   }\n" +
            "]\n"

    const val SIMPLE_TEXT = "Whats your name? choose below list!\n"
    const val IMAGE_REQUEST_TEXT = "Can you find this ingredients image and image link?\n"
}