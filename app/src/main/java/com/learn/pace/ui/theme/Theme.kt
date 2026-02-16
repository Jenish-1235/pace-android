package com.learn.pace.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = ReadWhite,
    secondary = ReadBlack,
    background = ReadBlack,
    onBackground = ReadWhite,

    surface = MatteBlack,
    onSurface = ReadWhite,

    error = ErrorRed,
    onError = ReadWhite,
)

private val LightColorScheme = lightColorScheme(
    primary = ReadBlack,
    onPrimary = ReadWhite,

    background = ReadWhite,
    onBackground = ReadBlack,

    surface = ReadWhite,
    onSurface = ReadBlack,

    error = ErrorRed,
    onError = ReadWhite,
)

val ColorScheme.success : Color
    get() = SuccessGreen

@Composable
fun PaceTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )

}