package com.example.cocktailapp

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun CocktailAppNavHost() {
    val navController = rememberNavController()

    NavHost(
        modifier = Modifier,
        navController = navController,
        startDestination = "Main Screen"
    ) {
        composable("Main Screen") {
            MainScreen(navController)
        }
        composable("Detail Screen") {
            DetailScreen()
        }
    }
}
