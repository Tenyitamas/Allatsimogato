package hu.test.creatit.allatsimogato.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = TextWhite,
    primaryVariant = Color.LightGray,
    secondary = Orange,
    background = Color.DarkGray,
    onBackground = TextWhite,
    surface = MediumGray,
    onSurface = TextWhite,
    onPrimary = Color.White,
    onSecondary = Color.White,
)

private val LightColorPalette = lightColors(
    primary = Color.Black,
    primaryVariant = Color.DarkGray,
    secondary = MediumBlue,
    background = Color.White,
    onBackground = Color.DarkGray,
    surface = Color.LightGray,
    onSurface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.White,
)


@Composable
fun AllatsimogatoTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        DarkColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}