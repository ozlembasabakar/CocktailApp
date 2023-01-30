package com.example.cocktailapp.domain

import com.example.cocktailapp.data.CocktailRepository
import javax.inject.Inject

class GetRandomCocktailUseCase @Inject constructor(
    private val cocktailRepository: CocktailRepository,
) {

    suspend operator fun invoke(): Cocktail? {
        return cocktailRepository.getRandomCocktail()
    }
}