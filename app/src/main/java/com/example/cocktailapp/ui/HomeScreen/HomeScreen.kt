package com.example.cocktailapp.ui.HomeScreen

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.cocktailapp.R
import com.example.cocktailapp.ui.HomeScreen.components.HomeScreenCocktailCard
import com.example.cocktailapp.ui.theme.CocktailAppTheme

@Composable
fun HomeScreen(navController: NavController) {

    //val homeScreenViewModel: HomeScreenViewModel = hiltViewModel()
    //val state by homeScreenViewModel.state.collectAsState()

    Surface(color = MaterialTheme.colors.background) {
        Box(contentAlignment = Alignment.Center,
            modifier = Modifier
                .padding(vertical = 100.dp, horizontal = 30.dp)
                .fillMaxSize()
        ) {
            HomeScreenCocktailCard(
                modifier = Modifier,
                onClick = {
                    navController.navigate("Detail Screen")
                }
            )
            /*
            LazyColumn {
                if (state.cocktails.isEmpty()) {
                    item {
                        CocktailCard(
                            modifier = Modifier,
                            text = "State Boş",
                            onClick = {
                                navController.navigate("Detail Screen")
                            }
                        )
                    }
                } else {
                    items(state.cocktails) { cocktail: CocktailData ->
                        CocktailCard(
                            modifier = Modifier,
                            text = cocktail.strDrink,
                            onClick = {
                                navController.navigate("Detail Screen")
                            }
                        )
                    }
                }
            }
            */
        }
    }
}

@Preview(name = "LightMode", showSystemUi = true)
@Preview(name = "DarkMode", uiMode = Configuration.UI_MODE_NIGHT_YES, showSystemUi = true)
@Composable
fun CocktailAppPreview() {
    CocktailAppTheme {
        val navController = rememberNavController()
        HomeScreen(navController = navController)
    }
}
