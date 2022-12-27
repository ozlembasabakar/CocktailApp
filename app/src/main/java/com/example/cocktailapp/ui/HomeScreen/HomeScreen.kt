package com.example.cocktailapp.ui.HomeScreen

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.cocktailapp.data.model.CocktailData
import com.example.cocktailapp.ui.HomeScreen.components.HomeScreenCocktailCard
import com.example.cocktailapp.ui.theme.CocktailAppTheme

@Composable
fun HomeScreen(
    navController: NavController,
    cocktailData: CocktailData?,
) {

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
                },
                cocktailData = cocktailData
            )
        }
    }
}


@Preview(name = "LightMode", showSystemUi = true)
@Preview(name = "DarkMode", uiMode = Configuration.UI_MODE_NIGHT_YES, showSystemUi = true)
@Composable
fun CocktailAppPreview() {
    CocktailAppTheme {
        val navController = rememberNavController()
        val homeScreenViewModel: HomeScreenViewModel = hiltViewModel()
        val state by homeScreenViewModel.state.collectAsState()


        HomeScreen(navController = navController,
            /*cocktailData = CocktailData(
                idDrink = R.string.idDrink.toString(),
                strMeasure1 = R.string.strMeasure1.toString(),
                strMeasure2 = R.string.strMeasure2.toString(),
                strMeasure3 = R.string.strMeasure2.toString(),
                strMeasure4 = R.string.strMeasure2.toString(),
                strAlcoholic = R.string.strAlcoholic.toString(),
                strDrink = R.string.strDrink.toString(),
                strDrinkThumb = R.drawable.ic_launcher_background.toString(),
                strGlass = R.string.strGlass.toString(),
                strIngredient1 = R.string.strIngredient1.toString(),
                strIngredient2 = R.string.strIngredient2.toString(),
                strIngredient3 = R.string.strIngredient3.toString(),
                strIngredient4 = R.string.strIngredient4.toString(),
                strInstructions = R.string.strInstructions.toString()
            )*/
            cocktailData = state.cocktail
        )
    }
}
