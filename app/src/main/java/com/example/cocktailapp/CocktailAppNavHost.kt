package com.example.cocktailapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cocktailapp.ui.DetailScreen.DetailScreen
import com.example.cocktailapp.ui.DetailScreen.DetailScreenViewModel
import com.example.cocktailapp.ui.HomeScreen.HomeScreen
import com.example.cocktailapp.ui.HomeScreen.HomeScreenViewModel

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun CocktailAppNavHost() {

    val navController = rememberNavController()

    val homeScreenViewModel: HomeScreenViewModel = hiltViewModel()
    val homeScreenViewState by homeScreenViewModel.state.collectAsStateWithLifecycle()

    val detailScreenViewModel: DetailScreenViewModel = hiltViewModel()
    val detailScreenViewState by detailScreenViewModel.state.collectAsStateWithLifecycle()

    NavHost(
        modifier = Modifier,
        navController = navController,
        startDestination = "Home Screen"
    ) {
        composable("Home Screen") {
            HomeScreen(navController, homeScreenViewState.cocktail)
        }
        composable("Detail Screen") {
            DetailScreen(detailScreenViewState.cocktail)
        }
    }
}
