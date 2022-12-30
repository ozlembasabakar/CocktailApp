package com.example.cocktailapp.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cocktails")
data class SavedCocktailData (
    @PrimaryKey
    @ColumnInfo(name = "idDrink")
    val idDrink: String,

    @ColumnInfo(name = "strAlcoholic")
    val strAlcoholic: String,

    @ColumnInfo(name = "strDrink")
    val strDrink: String,

    @ColumnInfo(name = "strDrinkThumb")
    val strDrinkThumb: String,

    @ColumnInfo(name = "strGlass")
    val strGlass: String,

    @ColumnInfo(name = "strIngredient1")
    val strIngredient1: String,

    @ColumnInfo(name = "strIngredient2")
    val strIngredient2: String,

    @ColumnInfo(name = "first_name")
    val strIngredient3: String,

    @ColumnInfo(name = "strIngredient3")
    val strIngredient4: String,

    @ColumnInfo(name = "strInstructions")
    val strInstructions: String,

    @ColumnInfo(name = "strMeasure1")
    val strMeasure1: String,

    @ColumnInfo(name = "strMeasure2")
    val strMeasure2: String,

    @ColumnInfo(name = "strMeasure3")
    val strMeasure3: String,

    @ColumnInfo(name = "strMeasure4")
    val strMeasure4: String,
)