package com.example.cocktailapp.data.network

import com.example.cocktailapp.data.model.CocktailData
import javax.inject.Inject

class CocktailRepository @Inject constructor(
    private val cocktailApi: CocktailApi,
) {
    suspend fun getRandomCocktail(): CocktailData? {
        return cocktailApi.getRandomCocktail().drinks.firstOrNull()
    }

    suspend fun getCocktailById(id: String): CocktailData? {
        return cocktailApi.getCocktailById(id).drinks.firstOrNull()
    }
}