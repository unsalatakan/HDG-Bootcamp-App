package tr.com.atakan.hdgbootcamp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.White

private val LightColorPalette = lightColors(
    primary = PantoneYellow,
    onPrimary = PantoneBlack,
    background = PantoneYellow,
    onBackground = PantoneBlack,
    surface = PantoneWhite,
    onSurface = PantoneBlack,
    secondary = PantoneWhite,
    onSecondary = PantoneBlack
)

@Composable
fun TechTalkAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {

    MaterialTheme(
        colors = LightColorPalette,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}


@Composable
fun JetpacklogindarklightTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}

private val DarkColorPalette = darkColors(
    primary = Purple500,
    primaryVariant = Purple200,
    secondary = Teal200,
    background = Black,
    onPrimary = White,
    onBackground = White,
    onSurface = Gray,
)