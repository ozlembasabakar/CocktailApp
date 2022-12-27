package com.example.cocktailapp.ui.HomeScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cocktailapp.data.model.CocktailData
import com.example.cocktailapp.data.model.SavedCocktailData
import com.example.cocktailapp.data.network.CocktailRepository
import com.example.cocktailapp.data.network.SavedCocktailRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val cocktailRepository: CocktailRepository,
    private val savedCocktailRepository: SavedCocktailRepository,
) : ViewModel() {

    private val _state = MutableStateFlow(HomeScreenViewState())
    val state: StateFlow<HomeScreenViewState>
        get() = _state

    init {
        viewModelScope.launch() {
            val cocktails = cocktailRepository.getRandomCocktail()
            _state.value = state.value.copy(cocktail = cocktails)
        }
    }

    fun saveToDb(cocktailData: CocktailData?) {
        val savedCocktailData = SavedCocktailData(
            idDrink = cocktailData!!.idDrink,
            strDrinkThumb = cocktailData.strDrinkThumb,
            strDrink = cocktailData.strDrink,
            strInstructions = cocktailData.strInstructions,
            strIngredient1 = cocktailData.strIngredient1,
            strIngredient2 = cocktailData.strIngredient2,
            strIngredient3 = cocktailData.strIngredient3,
            strIngredient4 = cocktailData.strIngredient4,
            strMeasure1 = cocktailData.strMeasure1,
            strMeasure2 = cocktailData.strMeasure2,
            strMeasure3 = cocktailData.strMeasure3,
            strMeasure4 = cocktailData.strMeasure4,
            strGlass = cocktailData.strGlass,
            strAlcoholic = cocktailData.strAlcoholic,
        )
        savedCocktailRepository.insertFavorite(savedCocktailData)
    }
}