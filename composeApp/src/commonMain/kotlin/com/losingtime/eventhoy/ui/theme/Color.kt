package com.losingtime.eventhoy.ui.theme


import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

data class AppColors(
    val primary: Color,
    val secondary: Color,

    val systemRed: Color,
    val systemOrange: Color,
    val systemGreen: Color,
    val systemBlue: Color,

    val background: Color,
    val background2: Color,
    val text: Color,
    val deactive: Color,
    val separator: Color,
    val body: Color,

    val gradients: Gradients
)

data class Gradients(
    val primary: Brush,
    val secondary: Brush,
    val azure: Brush,
    val gold: Brush,
    val lightGreen: Brush
)


val md_theme_main_primary = Color(0xFF00008B)
val md_theme_main_secondary = Color(0xFFFFA500)
val md_theme_system_red = Color(0xFFFF6961)
val md_theme_system_orange = Color(0xFFFFB340)
val md_theme_system_green = Color(0xFF30DB5B)
val md_theme_system_blue = Color(0xFF409CFF)

val md_theme_light_main_background = Color.White
val md_theme_light_main_background_2 = Color(0xFFF4F4F4)
val md_theme_light_main_text = Color(0xFF1B1212)
val md_theme_light_deactive = Color(0xFFDCDCDC)
val md_theme_light_separator = Color(0xFFE9E9E9)
val md_theme_light_body = Color(0xFF797979)

val md_theme_dark_main_background = Color(0xFF28282B)
val md_theme_dark_main_background_2 = Color(0xFF323235)
val md_theme_dark_main_text = Color(0xFFF4F4F4)
val md_theme_dark_deactive = Color(0xFF59595E)
val md_theme_dark_separator = Color(0xFF39393D)
val md_theme_dark_body = Color(0xFFA0A0A0)

val md_theme_gradients_primary = Brush.verticalGradient(
    colors = listOf(
        Color(0xFF7B79FF),
        Color(0xFF00008B)
    )
)
val md_theme_gradients_secondary = Brush.verticalGradient(
    colors = listOf(
        Color(0xFFFFF1D8),
        Color(0xFFFFA500)
    )
)
val md_theme_gradients_azzure = Brush.verticalGradient(
    colors = listOf(
        Color(0xFF46D2F),
        Color(0xFF5351F0)
    )
)
val md_theme_gradients_gold = Brush.verticalGradient(
    colors = listOf(
        Color(0xFFFFE6A4),
        Color(0xFFAD8211)
    )
)
val md_theme_gradients_light_green = Brush.verticalGradient(
    colors = listOf(
        Color(0xFFC5EDF5),
        Color(0xFF4A879A)
    )
)
