package com.example.cocktailapp.ui.HomeScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cocktailapp.data.remote.network.CocktailRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val cocktailRepository: CocktailRepository,
) : ViewModel() {

    private val _state = MutableStateFlow(HomeScreenViewState())
    val state: StateFlow<HomeScreenViewState>
        get() = _state

    init {
        fetchDataFromRepository()
    }

    private fun fetchDataFromRepository() {
        viewModelScope.launch() {
            val cocktails = cocktailRepository.getRandomCocktail()
            _state.value = state.value.copy(cocktail = cocktails)
        }
    }
}