package com.example.cocktailapp.ui.homeScreen

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.cocktailapp.ui.homeScreen.components.HomeScreenCocktailCard
import com.example.cocktailapp.ui.theme.Shapes

@Composable
fun HomeScreen(
    navController: NavController,
    cocktailSummary: CocktailSummary?,
) {
    Surface(color = MaterialTheme.colors.background) {
        Box(contentAlignment = Alignment.Center,
            modifier = Modifier
                .padding(vertical = 100.dp, horizontal = 30.dp)
                .fillMaxSize()
                .shadow(elevation = 10.dp, shape = Shapes.small)
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = rememberRipple(bounded = true),
                    onClick = {
                        navController.navigate("Detail Screen/${cocktailSummary?.id}")
                    },
                )
        ) {
            HomeScreenCocktailCard(
                modifier = Modifier,
                cocktailSummary = cocktailSummary
            )
        }
    }
}

@Preview(name = "LightMode", showSystemUi = true)
@Preview(name = "DarkMode", uiMode = Configuration.UI_MODE_NIGHT_YES, showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    // given
    val navController: NavController = rememberNavController()
    val cocktailSummary = CocktailSummary(
        imageUrl = "sasa",
        name = "Ayran",
        description = "Çalkala yavrum ÇAL-KA-LA",
        id = "1"
    )

    // then
    HomeScreen(
        cocktailSummary = cocktailSummary,
        navController = navController
    )
}
