package com.example.cocktailapp.data.network

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cocktailapp.data.model.SavedCocktailData

@Database(entities = [SavedCocktailData::class], version = 1)
abstract class CocktailDatabase : RoomDatabase() {
    abstract fun cocktailDao(): CocktailDao
}