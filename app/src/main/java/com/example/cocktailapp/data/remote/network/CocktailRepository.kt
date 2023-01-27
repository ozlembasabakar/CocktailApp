package com.example.cocktailapp.data.remote.network

import android.util.Log
import com.example.cocktailapp.data.local.model.SavedCocktailData
import com.example.cocktailapp.data.local.network.CocktailLocalDataSource
import com.example.cocktailapp.data.remote.model.CocktailData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CocktailRepository @Inject constructor(
    private val cocktailRemoteDataSource: CocktailRemoteDataSource,
    private val cocktailLocalDataSource: CocktailLocalDataSource,
) {
    suspend fun getRandomCocktail(): CocktailData? {
        withContext(Dispatchers.IO) {
            saveToDb(cocktailRemoteDataSource.getRandomCocktail())
            delay(500)
        }

        Log.d("lastIndex", "${cocktailLocalDataSource.getSavedCocktailList().size}")

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
        }.lastOrNull()
    }

    suspend fun getCocktailFromDatabaseById(): SavedCocktailData {
        return cocktailLocalDataSource.getSavedCocktailById(getRandomCocktail()?.idDrink)
    }

    private fun saveToDb(cocktailData: CocktailData?) {
        cocktailLocalDataSource.saveToDb(cocktailData = cocktailData)
    }
}