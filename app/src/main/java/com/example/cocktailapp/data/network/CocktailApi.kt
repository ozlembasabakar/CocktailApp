package com.example.cocktailapp.data.network

import com.example.cocktailapp.data.model.CocktailResponse
import retrofit2.http.GET
import retrofit2.http.Query

const val END_POINT_RANDOM = "random.php"
const val END_POINT_SEARCH_BY_ID = "lookup.php"

interface CocktailApi {

    @GET(END_POINT_RANDOM)
    suspend fun getRandomCocktail(): CocktailResponse

    @GET(END_POINT_SEARCH_BY_ID)
    suspend fun getCocktailById(
        @Query("i") id: String,
    ): CocktailResponse
}