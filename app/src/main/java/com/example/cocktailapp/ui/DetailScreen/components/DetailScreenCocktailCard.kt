package com.example.cocktailapp.ui.DetailScreen.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.example.cocktailapp.data.remote.model.CocktailData
import com.example.cocktailapp.ui.DetailScreen.DetailScreen
import com.example.cocktailapp.ui.HomeScreen.HomeScreenViewModel
import com.example.cocktailapp.ui.theme.CocktailAppTheme
import com.example.cocktailapp.ui.theme.Shapes
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun DetailScreenCocktailCard(
    modifier: Modifier = Modifier,
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
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
        ) {
            item {
                GlideImage(
                    imageModel = cocktailData?.strDrinkThumb,
                    contentDescription = stringResource(id = R.string.app_name),
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .clip(RoundedCornerShape(20.dp))
                        .fillMaxWidth()
                        //.weight(1f)
                )
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        //.weight(3f)
                        .padding(12.dp),
                    verticalArrangement = Arrangement.SpaceAround,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = cocktailData!!.strDrink,
                        style = MaterialTheme.typography.h2
                    )
                    Column {
                        Spacer(modifier = Modifier.height(12.dp))
                        Text(
                            text = stringResource(id = R.string.instructions),
                            style = MaterialTheme.typography.h1
                        )
                        Text(
                            text = cocktailData?.strInstructions,
                            style = MaterialTheme.typography.subtitle2
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        Column {
                            Text(
                                text = stringResource(id = R.string.ingredients),
                                style = MaterialTheme.typography.h1
                            )
                            Text(
                                text = cocktailData?.strMeasure1 + " of " + cocktailData?.strIngredient1,
                                style = MaterialTheme.typography.subtitle2
                            )
                            Text(
                                text = cocktailData?.strMeasure2 + " of " + cocktailData?.strIngredient2,
                                style = MaterialTheme.typography.subtitle2
                            )
                            Text(
                                text = cocktailData?.strMeasure3 + " of " + cocktailData?.strIngredient3,
                                style = MaterialTheme.typography.subtitle2
                            )
                            Text(
                                text = cocktailData?.strMeasure4 + " of " + cocktailData?.strIngredient4,
                                style = MaterialTheme.typography.subtitle2
                            )
                        }
                        Spacer(modifier = Modifier.height(12.dp))
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
                                text = cocktailData?.strGlass,
                                style = MaterialTheme.typography.subtitle2
                            )
                        }
                        Spacer(modifier = Modifier.height(12.dp))
                        Text(
                            text = cocktailData?.strAlcoholic,
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
        val homeScreenViewModel: HomeScreenViewModel = hiltViewModel()
        val state by homeScreenViewModel.state.collectAsState()

        DetailScreen(cocktailData = state.cocktail)
    }
}