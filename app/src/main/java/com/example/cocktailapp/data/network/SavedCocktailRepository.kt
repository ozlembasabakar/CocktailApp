package com.example.cocktailapp.data.network

import com.example.cocktailapp.data.model.SavedCocktailData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class SavedCocktailRepository @Inject constructor(private val cocktailDao: CocktailDao) {

    private val coroutineScope = CoroutineScope(Dispatchers.Default)

    fun insertFavorite(addSavedCocktailData: SavedCocktailData) {
        coroutineScope.launch(Dispatchers.IO) {
            cocktailDao.insertSavedCocktailList(addSavedCocktailData)
        }
    }

    suspend fun getSavedCocktailList(): List<SavedCocktailData> {
        return cocktailDao.getSavedCocktailList()
    }

    suspend fun getRandomCocktailFromRoom(): List<SavedCocktailData> {
        return cocktailDao.getSavedCocktailList()
    }
}