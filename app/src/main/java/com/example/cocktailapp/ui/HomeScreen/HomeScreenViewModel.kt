package com.example.cocktailapp.ui.HomeScreen

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cocktailapp.data.model.Drink
import com.example.cocktailapp.data.network.CocktailRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEmpty
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val cocktailRepository: CocktailRepository,
) : ViewModel() {


/*
    private val _state = MutableStateFlow(HomeScreenViewState(emptyList()))
    val state: StateFlow<HomeScreenViewState>
        get() = _state

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val cocktails = cocktailRepository.getCocktail()
            _state.value = state.value.copy(cocktails = cocktails)
        }
    }
*/
}