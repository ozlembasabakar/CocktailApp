package com.example.cocktailapp.data.remote.network

import com.example.cocktailapp.data.remote.model.CocktailResponse
import retrofit2.http.GET

const val END_POINT_RANDOM = "random.php"

interface CocktailApi {

    @GET(END_POINT_RANDOM)
    suspend fun getRandomCocktail(): CocktailResponse
}