package com.example.cocktailapp.data.remote.network

import com.example.cocktailapp.data.remote.model.CocktailData
import javax.inject.Inject

class CocktailRemoteDataSource @Inject constructor(
    private val cocktailApi: CocktailApi,
) {

    suspend fun getRandomCocktail(): CocktailData? {
        return cocktailApi.getRandomCocktail().drinks.firstOrNull()
    }

    suspend fun getCocktailById(id: String): CocktailData? {
        return cocktailApi.getCocktailById(id).drinks.firstOrNull()
    }
}