package com.example.cocktailapp.ui.DetailScreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cocktailapp.data.remote.network.CocktailRepository
import com.example.cocktailapp.ui.HomeScreen.HomeScreenViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailScreenViewModel @Inject constructor(
    private val cocktailRepository: CocktailRepository,
) : ViewModel() {

    private val _state = MutableStateFlow(HomeScreenViewState())
    val state: StateFlow<HomeScreenViewState>
        get() = _state

    init {
        viewModelScope.launch() {
            val cocktail = cocktailRepository.getCocktailById(state.value.cocktail!!.idDrink)
            _state.value = state.value.copy(cocktail = cocktail)
        }
        Log.d("getCocktailById", state.value.cocktail.toString())
    }
}