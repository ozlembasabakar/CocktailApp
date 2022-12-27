package com.example.cocktailapp

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cocktailapp.ui.DetailScreen.DetailScreen
import com.example.cocktailapp.ui.HomeScreen.HomeScreen
import com.example.cocktailapp.ui.HomeScreen.HomeScreenViewModel

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun CocktailAppNavHost() {

    val navController = rememberNavController()

    val homeScreenViewModel: HomeScreenViewModel = hiltViewModel()
    val state by homeScreenViewModel.state.collectAsState()

    NavHost(
        modifier = Modifier,
        navController = navController,
        startDestination = "Home Screen"
    ) {
        composable("Home Screen") {
            HomeScreen(navController, state.cocktail)
        }
        composable("Detail Screen") {
            DetailScreen(state.cocktail)
        }
    }
}
