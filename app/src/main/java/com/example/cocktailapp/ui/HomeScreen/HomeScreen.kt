package com.example.cocktailapp.ui.HomeScreen

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.cocktailapp.R
import com.example.cocktailapp.data.model.CocktailData
import com.example.cocktailapp.ui.theme.CocktailAppTheme

@Composable
fun HomeScreen(navController: NavController) {

    //val homeScreenViewModel: HomeScreenViewModel = hiltViewModel()
    //val state by homeScreenViewModel.state.collectAsState()

    Box(contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        /*
        LazyColumn {
            if (state.cocktails.isEmpty()) {
                item {
                    CocktailCard(
                        modifier = Modifier,
                        text = "State Boş",
                        onClick = {
                            navController.navigate("Detail Screen")
                        }
                    )
                }
            } else {
                items(state.cocktails) { cocktail: CocktailData ->
                    CocktailCard(
                        modifier = Modifier,
                        text = cocktail.strDrink,
                        onClick = {
                            navController.navigate("Detail Screen")
                        }
                    )
                }
            }
        }
        */
    }
}

@Composable
fun CocktailCard(
    modifier: Modifier = Modifier,
    text:String,
    onClick: () -> Unit,
) {

    //val homeScreenViewModel: HomeScreenViewModel = hiltViewModel()
    //val state by homeScreenViewModel.state.collectAsState()

    Card(
        elevation = 10.dp,
        modifier = modifier
            .background(MaterialTheme.colors.background)
            .padding(12.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(12.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = stringResource(id = R.string.app_name),
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = text)
            Button(
                onClick = onClick
            ) {
                Text(text = "Detail")
            }
        }
    }
}


@Preview(name = "LightMode")
@Preview(name = "DarkMode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun CocktailAppPreview() {
    CocktailAppTheme {
        val navController = rememberNavController()
        HomeScreen(navController = navController)
    }
}
