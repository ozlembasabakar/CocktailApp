package com.example.cocktailapp.ui.detailScreen

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cocktailapp.ui.detailScreen.components.DetailScreenCocktailCard
import com.example.cocktailapp.ui.theme.Shapes

@Composable
fun DetailScreen(
    detailScreenViewState: DetailScreenViewState,
) {

    Surface(color = MaterialTheme.colors.background) {
        Box(contentAlignment = Alignment.Center,
            modifier = Modifier
                .padding(vertical = 100.dp, horizontal = 30.dp)
                .fillMaxSize()
                .shadow(elevation = 10.dp, shape = Shapes.small)
        ) {
            DetailScreenCocktailCard(
                modifier = Modifier,
                cocktailDetail = detailScreenViewState.cocktailDetail
            )
        }
    }
}


@Preview(name = "LightMode")
@Preview(name = "DarkMode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun CocktailAppDetailScreenPreview() {
    CocktailAppTheme {
        val detailScreenViewModel: DetailScreenViewModel = hiltViewModel()
        val state by detailScreenViewModel.state.collectAsState()

        DetailScreen(cocktailData = state.cocktail)
    }
}