package com.example.cocktailapp

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.cocktailapp.ui.theme.CocktailAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            CocktailAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    CocktailAppNavHost()
                }
            }
        }
    }
}


@Composable
fun MainScreen(navController: NavController) {

    Box(contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        CocktailCard {
            navController.navigate("Detail Screen")
        }
    }
}

@Composable
fun CocktailCard(modifier: Modifier = Modifier, onClick: () -> Unit) {
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
            Text(text = "Title")
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
        MainScreen(navController = navController)
    }
}
