package com.example.cocktailapp.data.remote.network

import com.example.cocktailapp.data.local.network.CocktailLocalDataSource
import com.example.cocktailapp.data.remote.model.CocktailData
import javax.inject.Inject

class CocktailRepository @Inject constructor(
    private val cocktailRemoteDataSource: CocktailRemoteDataSource,
    private val cocktailLocalDataSource: CocktailLocalDataSource,
) {
    suspend fun getRandomCocktail(): CocktailData {
        saveToDb(cocktailRemoteDataSource.getRandomCocktail())
        return cocktailLocalDataSource.getSavedCocktailList().map {
            CocktailData(
                idDrink = it.idDrink,
                strDrinkThumb = it.strDrinkThumb,
                strDrink = it.strDrink,
                strInstructions = it.strInstructions,
                strIngredient1 = it.strIngredient1,
                strIngredient2 = it.strIngredient2,
                strIngredient3 = it.strIngredient3,
                strIngredient4 = it.strIngredient4,
                strMeasure1 = it.strMeasure1,
                strMeasure2 = it.strMeasure2,
                strMeasure3 = it.strMeasure3,
                strMeasure4 = it.strMeasure4,
                strGlass = it.strGlass,
                strAlcoholic = it.strAlcoholic,
            )
        }.random()
    }

    suspend fun getCocktailById(id: String): CocktailData? {
        return cocktailRemoteDataSource.getCocktailById(id)
    }

    fun saveToDb(cocktailData: CocktailData?) {
        cocktailLocalDataSource.saveToDb(cocktailData = cocktailData)
    }
}