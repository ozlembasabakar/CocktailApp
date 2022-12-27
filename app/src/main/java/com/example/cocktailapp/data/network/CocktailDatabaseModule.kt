package com.example.cocktailapp.data.network

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class CocktailDatabaseModule {
    @Provides
    fun provideCocktailDao(cocktailDatabase: CocktailDatabase): CocktailDao {
        return cocktailDatabase.cocktailDao()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): CocktailDatabase {
        return Room.databaseBuilder(
            appContext,
            CocktailDatabase::class.java,
            "CocktailApp"
        ).build()
    }
}