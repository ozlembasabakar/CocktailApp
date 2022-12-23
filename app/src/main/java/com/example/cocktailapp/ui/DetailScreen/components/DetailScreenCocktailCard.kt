package com.example.cocktailapp.ui.DetailScreen.components

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cocktailapp.ui.DetailScreen.DetailScreen
import com.example.cocktailapp.R
import com.example.cocktailapp.ui.theme.CocktailAppTheme
import com.example.cocktailapp.ui.theme.Shapes

@Composable
fun DetailScreenCocktailCard(
    modifier: Modifier = Modifier,
    //text:String,
) {

    //val homeScreenViewModel: HomeScreenViewModel = hiltViewModel()
    //val state by homeScreenViewModel.state.collectAsState()

    Card(
        shape = Shapes.small,
        elevation = 10.dp,
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.surface)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = stringResource(id = R.string.app_name),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .fillMaxWidth()
                    .weight(1f)
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(3f)
                    .padding(12.dp),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "Cocktail Name",
                    style = MaterialTheme.typography.h2
                )
                Column {
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = "Instructions",
                        style = MaterialTheme.typography.h1
                    )
                    Text(
                        text = "Mix all ingredients in a pitcher. Mix thoroughly and pour into whatever is available, the bigger the better! This drink packs a big punch, so don't over do it.",
                        style = MaterialTheme.typography.subtitle2
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Column {
                        Text(
                            text = "Ingredients",
                            style = MaterialTheme.typography.h1
                        )
                        Text(
                            text = "Measure1 of Ing1",
                            style = MaterialTheme.typography.subtitle2
                        )
                        Text(
                            text = "Measure2 of Ing2",
                            style = MaterialTheme.typography.subtitle2
                        )
                        Text(
                            text = "Measure3 of Ing3",
                            style = MaterialTheme.typography.subtitle2
                        )
                        Text(
                            text = "Measure4 of Ing4",
                            style = MaterialTheme.typography.subtitle2
                        )
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                    Column(
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Glass",
                            style = MaterialTheme.typography.h1
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Text(
                            text = "Punch bowl",
                            style = MaterialTheme.typography.subtitle2
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
        DetailScreen()
    }
}