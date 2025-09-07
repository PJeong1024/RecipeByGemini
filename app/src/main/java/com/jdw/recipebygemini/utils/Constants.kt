package com.jdw.recipebygemini.utils

object Constants {
    const val BASE_URL = "https://www.googleapis.com/books/v1/"

    const val BASEMENT_TEXT_1 =
        "Please tell me a dish list you can make with the ingredients below.\n" +
                "The information you need to give is a list of ingredients and a list of cooking steps.\n" +
                "When providing information, it must be provided in JSON format.\n" +
                "Text should be started with {, and ended with }, without any of useless text.\n" +
                "Please refer and follow below JSON format.\n" +
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

    const val BASEMENT_TEXT = """
You are a helpful assistant that provides a list of recipes.

Your task:
Using the following ingredients, return exactly one JSON object with a key `"dish_list"` that maps to a list of dishes.

Each dish object must have:
- "dish_name": String
- "ingredients": List of { "name": String, "amount": String }
- "steps": List of String

Output requirements:
- Respond only with valid JSON
- Do not include markdown syntax like ``` or language tags
- The response must start with `{` and end with `}`

Example format:
{
  "dish_list": [
    {
      "dish_name": "Scrambled Eggs with Chorizo",
      "ingredients": [
        { "name": "eggs", "amount": "2" },
        { "name": "chorizo", "amount": "50g" }
      ],
      "steps": [
        "Crack the eggs into a bowl and beat them.",
        "Cook the chorizo in a pan until browned."
      ]
    }
  ]
}

Ingredients:
"""

    const val SIMPLE_TEXT = "Whats your name? choose below list!\n"
    const val IMAGE_REQUEST_TEXT = "Can you find this ingredients image and image link?\n"
}