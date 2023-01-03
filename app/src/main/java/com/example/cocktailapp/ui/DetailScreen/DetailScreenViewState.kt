package com.example.cocktailapp.ui.DetailScreen

import com.example.cocktailapp.data.local.model.SavedCocktailData

data class DetailScreenViewState(
    val cocktail: SavedCocktailData? = null,
)
