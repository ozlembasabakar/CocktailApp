package com.example.cocktailapp.ui.DetailScreen.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.cocktailapp.R
import com.example.cocktailapp.data.local.model.SavedCocktailData
import com.example.cocktailapp.ui.DetailScreen.DetailScreen
import com.example.cocktailapp.ui.DetailScreen.DetailScreenViewModel
import com.example.cocktailapp.ui.theme.CocktailAppTheme
import com.example.cocktailapp.ui.theme.Shapes
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun DetailScreenCocktailCard(
    modifier: Modifier = Modifier,
    cocktailData: SavedCocktailData?,
) {
    Card(
        shape = Shapes.small,
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.surface)
    ) {
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
        ) {
            item {
                GlideImage(
                    imageModel = cocktailData?.strDrinkThumb,
                    contentDescription = stringResource(id = R.string.app_name),
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .clip(Shapes.small)
                        .fillMaxWidth()
                    //.weight(1f)
                )
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        //.weight(3f)
                        .padding(16.dp),
                    verticalArrangement = Arrangement.SpaceAround,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = cocktailData?.strDrink.toString(),
                        style = MaterialTheme.typography.h2
                    )
                    Column {
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = stringResource(id = R.string.instructions),
                            style = MaterialTheme.typography.h1
                        )
                        Text(
                            text = cocktailData?.strInstructions.toString(),
                            style = MaterialTheme.typography.subtitle2
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Column {
                            Text(
                                text = stringResource(id = R.string.ingredients),
                                style = MaterialTheme.typography.h1
                            )
                            if (cocktailData?.strMeasure1 != "null" || cocktailData.strIngredient1 != "null") {
                                Text(
                                    text = cocktailData?.strMeasure1 + " of " + cocktailData?.strIngredient1,
                                    style = MaterialTheme.typography.subtitle2
                                )
                            }
                            if (cocktailData?.strMeasure2 != "null" || cocktailData.strIngredient2 != "null") {
                                Text(
                                    text = cocktailData?.strMeasure2 + " of " + cocktailData?.strIngredient2,
                                    style = MaterialTheme.typography.subtitle2
                                )
                            }
                            if (cocktailData?.strMeasure3 != "null" || cocktailData.strIngredient3 != "null") {
                                Text(
                                    text = cocktailData?.strMeasure3 + " of " + cocktailData?.strIngredient3,
                                    style = MaterialTheme.typography.subtitle2
                                )
                            }
                            if (cocktailData?.strMeasure4 != "null" || cocktailData.strIngredient4 != "null") {
                                Text(
                                    text = cocktailData?.strMeasure4 + " of " + cocktailData?.strIngredient4,
                                    style = MaterialTheme.typography.subtitle2
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        Column(
                            horizontalAlignment = Alignment.Start,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = stringResource(id = R.string.glass),
                                style = MaterialTheme.typography.h1
                            )
                            Spacer(modifier = Modifier.width(12.dp))
                            Text(
                                text = cocktailData?.strGlass.toString(),
                                style = MaterialTheme.typography.subtitle2
                            )
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = cocktailData?.strAlcoholic.toString(),
                            style = MaterialTheme.typography.h1
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
        val detailScreenViewModel: DetailScreenViewModel = hiltViewModel()
        val state by detailScreenViewModel.state.collectAsState()

        DetailScreen(cocktailData = state.cocktail)
    }
}
