package com.example.cocktailapp.ui.HomeScreen.components

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.cocktailapp.R
import com.example.cocktailapp.ui.HomeScreen.HomeScreen
import com.example.cocktailapp.ui.theme.CocktailAppTheme
import com.example.cocktailapp.ui.theme.Shapes

@Composable
fun HomeScreenCocktailCard(
    modifier: Modifier = Modifier,
    //text:String,
    onClick: () -> Unit,
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
            verticalArrangement = Arrangement.SpaceBetween,
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
                    .weight(3f)
            )
            Spacer(modifier = Modifier.height(12.dp))
            Column(
                modifier = Modifier
                    .weight(2f)
                    .fillMaxSize()
                    .padding(12.dp),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "Cocktail Name",
                    style = MaterialTheme.typography.h2,
                    modifier = Modifier
                        //.align(Alignment.CenterStart)
                )
                Spacer(modifier = Modifier.height(12.dp))
                Button(
                    onClick = onClick,
                    colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primaryVariant),
                    shape = MaterialTheme.shapes.small,
                    modifier = Modifier
                        //.align(Alignment.BottomStart)
                ) {
                    Text(
                        text = "Detail",
                        style = MaterialTheme.typography.button,
                        modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                    )
                }

            }
            /*Box(
                modifier = Modifier
                    .weight(2f)
                    .fillMaxSize()
                    .padding(12.dp)
            ) {
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