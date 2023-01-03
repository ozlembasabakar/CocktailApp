package com.example.cocktailapp.ui.DetailScreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cocktailapp.data.remote.network.CocktailRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailScreenViewModel @Inject constructor(
    private val cocktailRepository: CocktailRepository,
) : ViewModel() {

    private val _state = MutableStateFlow(DetailScreenViewState())
    val state: StateFlow<DetailScreenViewState>
        get() = _state

    init {
        fetchDataFromRepository()

        Log.d("state", state.value.cocktail.toString())
    }
// 17835
    fun fetchDataFromRepository() {
        viewModelScope.launch() {
            val cocktail = cocktailRepository.getCocktailFromDatabaseById()
            _state.value = state.value.copy(cocktail = cocktail)

            Log.d("getSavedCocktailById", cocktailRepository.getCocktailFromDatabaseById().toString())
        }
    }
}