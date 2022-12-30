package com.example.cocktailapp.ui.HomeScreen

import com.example.cocktailapp.data.remote.model.CocktailData

data class HomeScreenViewState(
    val cocktail: CocktailData? = null,
)