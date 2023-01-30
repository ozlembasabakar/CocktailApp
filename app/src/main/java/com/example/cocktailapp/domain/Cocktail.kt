package com.example.cocktailapp.domain

data class Cocktail(
    val id: String,
    val name: String,
    val imageUrl: String,
    val description: String,
    val ingredients: List<Ingredient>,
    val container: String,
    val alcoholic: String,
)

data class Ingredient(
    val name: String,
    val measure: String,
)