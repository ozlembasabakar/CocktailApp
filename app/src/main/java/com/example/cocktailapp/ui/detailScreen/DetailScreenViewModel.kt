package com.example.cocktailapp.ui.detailScreen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cocktailapp.domain.GetCocktailByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class DetailScreenViewModel @Inject constructor(
    private val getCocktailByIdUseCase: GetCocktailByIdUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = MutableStateFlow(DetailScreenViewState(cocktailDetail = null))
    val state: StateFlow<DetailScreenViewState> = _state.asStateFlow()
    // get() = _state

    init {
        fetchDataFromUseCase(savedStateHandle.get<String>("cocktailId").orEmpty())

        //Log.d("state", state.value.cocktail.toString())
    }

    fun fetchDataFromUseCase(cocktailId: String) {
        viewModelScope.launch() {
            withContext(Dispatchers.Default) {
                val cocktail = getCocktailByIdUseCase(cocktailId = cocktailId)

                val cocktailDetail = CocktailDetail(
                    imageUrl = cocktail.imageUrl,
                    name = cocktail.name,
                    description = cocktail.description,
                    ingredients = cocktail.ingredients.map { ingredient ->
                        ingredient.measure + " of " + ingredient.name
                    },
                    container = cocktail.container,
                    alcoholic = cocktail.alcoholic
                )
                //_state.value = state.value.copy(cocktail = cocktail)
                _state.update { currentState ->
                    currentState.copy(
                        cocktailDetail = cocktailDetail
                    )
                }
            }
        }
    }
}