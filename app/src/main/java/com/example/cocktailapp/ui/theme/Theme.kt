package com.example.cocktailapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.cocktailapp.BuildConfig.BUILD_TYPE

private val DarkColorPaletteDebug = darkColors(
    primary = Purple40,
    primaryVariant = PurpleGrey40,
    secondary = Pink40
)

private val LightColorPaletteDebug = lightColors(
    primary = Purple80,
    primaryVariant = PurpleGrey80,
    secondary = Pink80
)

private val LightColorPaletteRelease = lightColors(
    surface = SurfaceLight,
    background = BackgroundLight,
    onSurface = Color.Black
)

private val DarkColorPaletteRelease = darkColors(
    surface = SurfaceDark,
    background = BackgroundDark,
    onSurface = Color.White
)

@Composable
fun CocktailAppTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (BUILD_TYPE == "debug") {
        if (darkTheme) DarkColorPaletteDebug else LightColorPaletteDebug
    } else {
        if (darkTheme) DarkColorPaletteRelease else LightColorPaletteRelease
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}