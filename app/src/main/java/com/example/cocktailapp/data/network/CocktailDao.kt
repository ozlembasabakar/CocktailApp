package com.example.cocktailapp.data.network

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cocktailapp.data.model.SavedCocktailData

@Dao
interface CocktailDao {

    @Query("SELECT * FROM cocktails")
    fun getSavedCocktailList(): List<SavedCocktailData>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSavedCocktailList(savedCocktailData: SavedCocktailData)
}