package com.example.cocktailapp.ui.homeScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cocktailapp.domain.GetRandomCocktailUseCase
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
class HomeScreenViewModel @Inject constructor(
    private val getRandomCocktailUseCase: GetRandomCocktailUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow(HomeScreenViewState(cocktailSummary = null))
    val state: StateFlow<HomeScreenViewState> = _state.asStateFlow()
    // get() = _state

    init {
        fetchDataFromUseCase()
    }

    private fun fetchDataFromUseCase() {
        viewModelScope.launch() {
            withContext(Dispatchers.IO) {
                val cocktail = getRandomCocktailUseCase()

                val cocktailSummary = CocktailSummary(
                    id = cocktail?.id.orEmpty(),
                    imageUrl = cocktail?.imageUrl.orEmpty(),
                    name = cocktail?.name.orEmpty(),
                    description = cocktail?.description.orEmpty()
                )
                //_state.value = state.value.copy(cocktail = cocktails)
                _state.update { currentState ->
                    currentState.copy(
                        cocktailSummary = cocktailSummary
                    )
                }
            }
        }
    }
}