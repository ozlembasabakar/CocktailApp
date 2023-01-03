package com.example.cocktailapp.data.local.network

import androidx.room.*
import com.example.cocktailapp.data.local.model.SavedCocktailData

@Dao
interface CocktailDao {

    @Query("SELECT * FROM cocktails")
    fun getSavedCocktailList(): List<SavedCocktailData>

    @Query("SELECT * FROM cocktails WHERE idDrink = :id")
    fun getSavedCocktailById(id: String?): SavedCocktailData

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSavedCocktailList(savedCocktailData: SavedCocktailData)
}