package com.example.cocktailapp

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cocktailapp.ui.HomeScreen.HomeScreen

@Composable
fun CocktailAppNavHost() {
    val navController = rememberNavController()

    NavHost(
        modifier = Modifier,
        navController = navController,
        startDestination = "Home Screen"
    ) {
        composable("Home Screen") {
            HomeScreen(navController)
        }
        composable("Detail Screen") {
            DetailScreen()
        }
    }
}
