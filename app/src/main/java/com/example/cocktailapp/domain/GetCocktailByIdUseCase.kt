package com.example.cocktailapp.domain

import com.example.cocktailapp.data.CocktailRepository
import javax.inject.Inject

class GetCocktailByIdUseCase @Inject constructor(
    private val cocktailRepository: CocktailRepository,
) {

    operator fun invoke(cocktailId: String): Cocktail {
        return cocktailRepository.getCocktailFromDatabaseById(cocktailId = cocktailId)
    }
}