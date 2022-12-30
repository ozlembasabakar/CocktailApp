package com.example.cocktailapp.data.remote.network

import com.example.cocktailapp.data.local.model.SavedCocktailData
import com.example.cocktailapp.data.local.network.CocktailLocalDataSource
import com.example.cocktailapp.data.remote.model.CocktailData
import javax.inject.Inject

class CocktailRepository @Inject constructor(
    private val cocktailRemoteDataSource: CocktailRemoteDataSource,
    private val cocktailLocalDataSource: CocktailLocalDataSource,
) {
    suspend fun getRandomCocktail(): CocktailData? {
        return cocktailRemoteDataSource.getRandomCocktail()
    }

    suspend fun getCocktailById(id: String): CocktailData? {
        return cocktailRemoteDataSource.getCocktailById(id)
    }

    fun insertCocktailList(addSavedCocktailData: SavedCocktailData) {
        return cocktailLocalDataSource.insertCocktailList(addSavedCocktailData)
    }
}