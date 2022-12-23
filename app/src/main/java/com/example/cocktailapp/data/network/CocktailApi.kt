package com.example.cocktailapp.data.network

import com.example.cocktailapp.data.model.Drink
import retrofit2.http.GET

const val END_POINT = "random.php"
const val END_POINT_SEARCH_BY_ID = "lookup.php?i=11007"
const val END_POINT_SEARCH_BY_NAME = "search.php?s=margarita"

interface CocktailApi {

    @GET(END_POINT_SEARCH_BY_NAME)
    suspend fun getCocktail(): Drink

}