package com.example.cocktailapp.ui.DetailScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.cocktailapp.data.local.model.SavedCocktailData
import com.example.cocktailapp.ui.DetailScreen.components.DetailScreenCocktailCard

@Composable
fun DetailScreen(
    cocktailData: SavedCocktailData?,
) {

    Surface(color = MaterialTheme.colors.background) {
        Box(contentAlignment = Alignment.Center,
            modifier = Modifier
                .padding(vertical = 100.dp, horizontal = 30.dp)
                .fillMaxSize()
        ) {
            DetailScreenCocktailCard(
                modifier = Modifier,
                cocktailData = cocktailData
            )
        }
    }
}


/*@Preview(name = "LightMode")
@Preview(name = "DarkMode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun CocktailAppDetailScreenPreview() {
    CocktailAppTheme {
        val homeScreenViewModel: HomeScreenViewModel = hiltViewModel()
        val state by homeScreenViewModel.state.collectAsState()

        DetailScreen(cocktailData = state.cocktail)
    }
}*/
