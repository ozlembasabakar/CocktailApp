package com.example.cocktailapp.data.network

import android.app.Application
import android.util.Log
import com.example.cocktailapp.R
import com.example.cocktailapp.data.model.CocktailData
import com.example.cocktailapp.data.model.Drink
import javax.inject.Inject


@Suppress("UNREACHABLE_CODE")
class CocktailRepository @Inject constructor(
    private val cocktailApi: CocktailApi,
) {

    suspend fun getCocktail(): Drink {
        return cocktailApi.getCocktail()
    }
}