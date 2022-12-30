package com.example.cocktailapp.ui.HomeScreen.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.example.cocktailapp.R
import com.example.cocktailapp.data.remote.model.CocktailData
import com.example.cocktailapp.ui.HomeScreen.HomeScreen
import com.example.cocktailapp.ui.HomeScreen.HomeScreenViewModel
import com.example.cocktailapp.ui.theme.CocktailAppTheme
import com.example.cocktailapp.ui.theme.Shapes
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun HomeScreenCocktailCard(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    cocktailData: CocktailData?,
) {

    Card(
        shape = Shapes.small,
        elevation = 10.dp,
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.surface)
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
        ) {
            item {
                GlideImage(
                    imageModel = cocktailData?.strDrinkThumb,
                    contentDescription = stringResource(id = R.string.app_name),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clip(RoundedCornerShape(20.dp))
                        .fillMaxWidth()
                        //.weight(3f)
                )
                Spacer(modifier = Modifier.height(12.dp))
                Column(
                    modifier = Modifier
                        //.weight(2f)
                        .fillMaxSize()
                        .padding(12.dp),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = cocktailData?.strDrink ?: "",
                        style = MaterialTheme.typography.h2,
                        modifier = Modifier
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = cocktailData?.strInstructions ?: "",
                        style = MaterialTheme.typography.subtitle1,
                        modifier = Modifier,
                        maxLines = 3,
                        overflow = TextOverflow.Ellipsis
                    )

                    Spacer(modifier = Modifier.height(12.dp))
                    Button(
                        onClick = onClick,
                        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primaryVariant),
                        shape = MaterialTheme.shapes.small,
                        modifier = Modifier
                    ) {
                        Text(
                            text = stringResource(id = R.string.detail),
                            style = MaterialTheme.typography.button,
                            modifier = Modifier
                                .padding(start = 16.dp, end = 16.dp)
                        )
                    }
                }
            }
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

        HomeScreen(navController = navController, state.cocktail)
    }
}