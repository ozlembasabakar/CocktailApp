package com.example.cocktailapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.cocktailapp.ui.detailScreen.DetailScreen
import com.example.cocktailapp.ui.detailScreen.DetailScreenViewModel
import com.example.cocktailapp.ui.homeScreen.HomeScreen
import com.example.cocktailapp.ui.homeScreen.HomeScreenViewModel

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun CocktailAppNavHost() {

    val navController = rememberNavController()

    val homeScreenViewModel: HomeScreenViewModel = hiltViewModel()
    val homeScreenViewState by homeScreenViewModel.state.collectAsStateWithLifecycle()

    NavHost(
        modifier = Modifier,
        navController = navController,
        startDestination = "Home Screen"
    ) {
        composable("Home Screen") {
            HomeScreen(
                navController = navController,
                cocktailSummary = homeScreenViewState.cocktailSummary
            )
        }
        composable(
            "Detail Screen/{cocktailId}",
            arguments = listOf(navArgument("cocktailId") { type = NavType.StringType })
        ) {
            val detailScreenViewModel: DetailScreenViewModel = hiltViewModel()
            val detailScreenViewState by detailScreenViewModel.state.collectAsStateWithLifecycle()

            DetailScreen(detailScreenViewState = detailScreenViewState)
        }
    }
}