package com.example.cocktailapp.ui.detailScreen

data class CocktailDetail(
    val imageUrl: String,
    val name: String,
    val description: String,
    val ingredients: List<String>,
    val container: String,
    val alcoholic: String,
)
