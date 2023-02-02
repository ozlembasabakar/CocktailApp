package com.example.cocktailapp.data.local.network

import androidx.room.*
import com.example.cocktailapp.data.local.model.SavedCocktailData

@Dao
interface CocktailDao {

    @Query("SELECT * FROM cocktails")
    fun getCocktailListFromDatabase(): List<SavedCocktailData>

    @Query("SELECT * FROM cocktails WHERE idDrink = :id")
    fun getCocktailByIdFromDatabase(id: String?): SavedCocktailData

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCocktailFromDatabase(savedCocktailData: SavedCocktailData)
}