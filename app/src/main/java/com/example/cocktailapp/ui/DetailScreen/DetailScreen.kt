package com.example.cocktailapp

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.cocktailapp.ui.theme.CocktailAppTheme

@Composable
fun DetailScreen() {
    Surface(
        color = MaterialTheme.colors.background) {
        Box(contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(text = "Detail")
        }
    }
}

@Preview(name = "LightMode")
@Preview(name = "DarkMode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun CocktailAppDetailScreenPreview() {
    CocktailAppTheme {
        DetailScreen()
    }
}
