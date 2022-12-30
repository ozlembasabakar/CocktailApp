package com.example.cocktailapp.data.remote.network

import com.example.cocktailapp.data.remote.model.CocktailData
import javax.inject.Inject

class CocktailRemoteDataSource @Inject constructor(
    private val cocktailApi: CocktailApi,
) {

    suspend fun getRandomCocktail(): CocktailData? {
        //insertFavorite(cocktailApi.getRandomCocktail().drinks.firstOrNull())
        //return daodaki get fonksiyonu
        //insertCocktailList(cocktailApi.getRandomCocktail().drinks.firstOrNull())

        return cocktailApi.getRandomCocktail().drinks.firstOrNull()
    }

    suspend fun getCocktailById(id: String): CocktailData? {
        return cocktailApi.getCocktailById(id).drinks.firstOrNull()
    }
}