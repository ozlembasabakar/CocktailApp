package com.example.cocktailapp.ui.homeScreen.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cocktailapp.R
import com.example.cocktailapp.ui.homeScreen.CocktailSummary
import com.example.cocktailapp.ui.theme.Shapes
import com.skydoves.landscapist.glide.GlideImage

@Suppress("UNUSED_EXPRESSION")
@Composable
fun HomeScreenCocktailCard(
    modifier: Modifier = Modifier,
    cocktailSummary: CocktailSummary?,
) {

    Card(
        shape = Shapes.small,
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
                    imageModel = cocktailSummary?.imageUrl,
                    contentDescription = cocktailSummary?.name,
                    previewPlaceholder = R.drawable.ic_launcher_foreground,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clip(Shapes.small)
                        .fillMaxWidth()
                    //.weight(3f)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Column(
                    modifier = Modifier
                        //.weight(2f)
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = cocktailSummary?.name.orEmpty(),
                        style = MaterialTheme.typography.h2,
                        modifier = Modifier,
                        color = MaterialTheme.colors.onSurface
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = cocktailSummary?.description.orEmpty(),
                        style = MaterialTheme.typography.subtitle1,
                        modifier = Modifier,
                        maxLines = 3,
                        overflow = TextOverflow.Ellipsis,
                        color = MaterialTheme.colors.onSurface
                    )
                }
            }
        }
    }
}

@Preview(name = "LightMode", showSystemUi = true)
@Preview(name = "DarkMode", uiMode = Configuration.UI_MODE_NIGHT_YES, showSystemUi = true)
@Composable
private fun HomeScreenCocktailCardPreview() {
    // given
    val cocktailSummary = CocktailSummary(
        imageUrl = "sasa",
        name = "Ayran",
        description = "Çalkala yavrum ÇAL-KA-LA",
        id = "1"
    )

    // then
    HomeScreenCocktailCard(
        cocktailSummary = cocktailSummary
    )
}