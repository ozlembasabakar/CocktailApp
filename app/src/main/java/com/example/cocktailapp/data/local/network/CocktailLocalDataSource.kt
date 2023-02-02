package com.example.cocktailapp.data.local.network

import android.util.Log
import com.example.cocktailapp.data.local.model.SavedCocktailData
import com.example.cocktailapp.data.remote.model.CocktailData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


class CocktailLocalDataSource @Inject constructor(
    private val cocktailDao: CocktailDao,
) {

    private val coroutineScope = CoroutineScope(Dispatchers.Default)

    fun getCocktailListFromDatabase(): List<SavedCocktailData> {
        Log.d("CocktailLocalDataSource", "${(cocktailDao.getCocktailListFromDatabase().size) - 1}")

        return cocktailDao.getCocktailListFromDatabase()
    }

    fun getCocktailByIdFromDatabase(id: String?): SavedCocktailData {
        return cocktailDao.getCocktailByIdFromDatabase(id)
    }

    private fun insertCocktailFromDatabase(addSavedCocktailData: SavedCocktailData) {
        coroutineScope.launch(Dispatchers.IO) {
            cocktailDao.insertCocktailFromDatabase(addSavedCocktailData)
        }
    }

    fun saveCocktailToDb(cocktailData: CocktailData?) {
        val savedCocktailData = SavedCocktailData(
            idDrink = cocktailData?.idDrink ?: "null",
            strDrinkThumb = cocktailData?.strDrinkThumb ?: "null",
            strDrink = cocktailData?.strDrink ?: "null",
            strInstructions = cocktailData?.strInstructions ?: "null",
            strIngredient1 = cocktailData?.strIngredient1 ?: "null",
            strIngredient2 = cocktailData?.strIngredient2 ?: "null",
            strIngredient3 = cocktailData?.strIngredient3 ?: "null",
            strIngredient4 = cocktailData?.strIngredient4 ?: "null",
            strMeasure1 = cocktailData?.strMeasure1 ?: "null",
            strMeasure2 = cocktailData?.strMeasure2 ?: "null",
            strMeasure3 = cocktailData?.strMeasure3 ?: "null",
            strMeasure4 = cocktailData?.strMeasure4 ?: "null",
            strGlass = cocktailData?.strGlass ?: "null",
            strAlcoholic = cocktailData?.strAlcoholic ?: "null",
        )
        insertCocktailFromDatabase(savedCocktailData)
    }
}