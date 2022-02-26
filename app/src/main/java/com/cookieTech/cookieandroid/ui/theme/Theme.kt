package com.cookieTech.cookieandroid.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable


private val DarkColorPalette = darkColors(
    /*primary = Purple200,
    primaryVariant = Red,
    secondary = Teal200,
    surface = Green
    primary = primaryDarkColor,*/
)

private val LightColorPalette = lightColors(
    primary = primaryLightColor,
    background = backgroundColor
   /* primaryVariant = primaryLightColor,
    secondary = secondaryColor,
    secondaryVariant = secondaryLightColor,*/
    /*surface = Teal200,
    onBackground = Purple700,
    background = Teal200*/

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)


@Composable
fun CookieAndroidTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = LightColorPalette, //use colors to support both dark and light color
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}