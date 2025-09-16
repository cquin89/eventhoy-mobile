package com.losingtime.eventhoy.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.staticCompositionLocalOf

val LightColors = AppColors(
    primary = md_theme_main_primary,
    secondary = md_theme_main_secondary,

    systemRed = md_theme_system_red,
    systemOrange = md_theme_system_orange,
    systemGreen = md_theme_system_green,
    systemBlue = md_theme_system_blue,

    background = md_theme_light_main_background,
    background2 = md_theme_light_main_background_2,
    text = md_theme_light_main_text,
    deactive = md_theme_light_deactive,
    separator = md_theme_light_separator,
    body = md_theme_light_body,

    gradients = Gradients(
        primary = md_theme_gradients_primary,
        secondary = md_theme_gradients_secondary,
        azure = md_theme_gradients_azzure,
        gold = md_theme_gradients_gold,
        lightGreen = md_theme_gradients_light_green
    )
)

val DarkColors = AppColors(
    primary = md_theme_main_primary,
    secondary = md_theme_main_secondary,

    systemRed = md_theme_system_red,
    systemOrange = md_theme_system_orange,
    systemGreen = md_theme_system_green,
    systemBlue = md_theme_system_blue,

    background = md_theme_dark_main_background,
    background2 =md_theme_dark_main_background_2,
    text = md_theme_dark_main_text,
    deactive = md_theme_dark_deactive,
    separator =md_theme_dark_separator,
    body = md_theme_dark_body,

    gradients = Gradients(
        primary = md_theme_gradients_primary,
        secondary = md_theme_gradients_secondary,
        azure = md_theme_gradients_azzure,
        gold = md_theme_gradients_gold,
        lightGreen = md_theme_gradients_light_green
    )
)

fun lightColorSchemeFromApp(appColors: AppColors): ColorScheme {
    return lightColorScheme(
        primary = appColors.primary,
        secondary = appColors.secondary,
        background = appColors.background,
        surface = appColors.background2,
        onBackground = appColors.text,
        onSurface = appColors.body,
        error = appColors.systemRed,
    )
}

fun darkColorSchemeFromApp(appColors: AppColors): ColorScheme {
    return darkColorScheme(
        primary = appColors.primary,
        secondary = appColors.secondary,
        background = appColors.background,
        surface = appColors.background2,
        onBackground = appColors.text,
        onSurface = appColors.body,
        error = appColors.systemRed,
    )
}

val LocalAppColors = staticCompositionLocalOf { LightColors }

@Composable
fun EventhoyTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColors else LightColors

    val materialColors = if (darkTheme) {
        darkColorSchemeFromApp(colors)
    } else {
        lightColorSchemeFromApp(colors)
    }

    CompositionLocalProvider(LocalAppColors provides colors) {
        MaterialTheme(
            colorScheme = materialColors,
            typography = Typography,
            content = content
        )
    }
}

val colors: AppColors
    @Composable
    get() = LocalAppColors.current