package com.example.cocktailapp.ui.detailScreen.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cocktailapp.R
import com.example.cocktailapp.ui.detailScreen.CocktailDetail
import com.example.cocktailapp.ui.theme.Shapes
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun DetailScreenCocktailCard(
    modifier: Modifier = Modifier,
    cocktailDetail: CocktailDetail?,
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
                    imageModel = cocktailDetail?.imageUrl,
                    contentDescription = cocktailDetail?.name,
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
                        text = cocktailDetail?.name.orEmpty(),
                        style = MaterialTheme.typography.h2,
                        color = MaterialTheme.colors.onSurface
                    )
                    Column {
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = stringResource(id = R.string.instructions),
                            style = MaterialTheme.typography.h1,
                            color = MaterialTheme.colors.onSurface
                        )
                        Text(
                            text = cocktailDetail?.description.orEmpty(),
                            style = MaterialTheme.typography.subtitle2,
                            color = MaterialTheme.colors.onSurface
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = stringResource(id = R.string.ingredients),
                            style = MaterialTheme.typography.h1,
                            color = MaterialTheme.colors.onSurface
                        )
                        cocktailDetail?.ingredients?.forEach { ingredient ->
                            Text(
                                text = ingredient,
                                style = MaterialTheme.typography.subtitle2,
                                color = MaterialTheme.colors.onSurface
                            )
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        Column(
                            horizontalAlignment = Alignment.Start,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = stringResource(id = R.string.glass),
                                style = MaterialTheme.typography.h1,
                                color = MaterialTheme.colors.onSurface
                            )
                            Spacer(modifier = Modifier.width(12.dp))
                            Text(
                                text = cocktailDetail?.container.orEmpty(),
                                style = MaterialTheme.typography.subtitle2,
                                color = MaterialTheme.colors.onSurface
                            )
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = cocktailDetail?.alcoholic.orEmpty(),
                            style = MaterialTheme.typography.h1,
                            color = MaterialTheme.colors.onSurface
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
