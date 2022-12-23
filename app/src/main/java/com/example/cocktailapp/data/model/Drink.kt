package com.example.cocktailapp.data.model


import com.google.gson.annotations.SerializedName

data class Drink(
    @SerializedName("drinks")
    val drinks: List<Drink>,
)