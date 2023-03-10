package com.example.cocktailapp.data

import android.util.Log
import com.example.cocktailapp.data.local.network.CocktailLocalDataSource
import com.example.cocktailapp.data.remote.model.CocktailData
import com.example.cocktailapp.data.remote.network.CocktailRemoteDataSource
import com.example.cocktailapp.domain.Cocktail
import com.example.cocktailapp.domain.Ingredient
import javax.inject.Inject

class CocktailRepository @Inject constructor(
    private val cocktailRemoteDataSource: CocktailRemoteDataSource,
    private val cocktailLocalDataSource: CocktailLocalDataSource,
) {
    suspend fun getRandomCocktail(): Cocktail? {
        saveCocktailToDb(cocktailRemoteDataSource.getRandomCocktail())

        Log.d("getCocktailListFromDb",
            "${cocktailLocalDataSource.getCocktailListFromDatabase().size}")

        return cocktailLocalDataSource.getCocktailListFromDatabase().map {
            Cocktail(
                id = it.idDrink,
                imageUrl = it.strDrinkThumb,
                name = it.strDrink,
                description = it.strInstructions,
                ingredients = listOf<Ingredient>(
                    Ingredient(name = it.strIngredient1, measure = it.strMeasure1),
                    Ingredient(name = it.strIngredient2, measure = it.strMeasure2),
                    Ingredient(name = it.strIngredient3, measure = it.strMeasure3),
                    Ingredient(name = it.strIngredient4, measure = it.strMeasure4),
                ),
                container = it.strGlass,
                alcoholic = it.strAlcoholic,
            )
        }.lastOrNull()
    }

    fun getCocktailFromDatabaseById(cocktailId: String): Cocktail {
        val savedCocktail = cocktailLocalDataSource.getCocktailByIdFromDatabase(cocktailId)
        return Cocktail(
            id = savedCocktail.idDrink,
            imageUrl = savedCocktail.strDrinkThumb,
            name = savedCocktail.strDrink,
            description = savedCocktail.strInstructions,
            ingredients = listOf<Ingredient>(
                Ingredient(name = savedCocktail.strIngredient1,
                    measure = savedCocktail.strMeasure1),
                Ingredient(name = savedCocktail.strIngredient2,
                    measure = savedCocktail.strMeasure2),
                Ingredient(name = savedCocktail.strIngredient3,
                    measure = savedCocktail.strMeasure3),
                Ingredient(name = savedCocktail.strIngredient4,
                    measure = savedCocktail.strMeasure4),
            ),
            container = savedCocktail.strGlass,
            alcoholic = savedCocktail.strAlcoholic,
        )
    }

    private fun saveCocktailToDb(cocktailData: CocktailData?) {
        cocktailLocalDataSource.saveCocktailToDb(cocktailData = cocktailData)
    }
}