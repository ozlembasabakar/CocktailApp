package com.example.cocktailapp.data.local.network

import com.example.cocktailapp.data.local.model.SavedCocktailData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


class CocktailLocalDataSource @Inject constructor(
    private val cocktailDao: CocktailDao,
) {

    private val coroutineScope = CoroutineScope(Dispatchers.Default)

    fun insertCocktailList(addSavedCocktailData: SavedCocktailData) {
        coroutineScope.launch(Dispatchers.IO) {
            cocktailDao.insertSavedCocktailList(addSavedCocktailData)
        }
    }
}