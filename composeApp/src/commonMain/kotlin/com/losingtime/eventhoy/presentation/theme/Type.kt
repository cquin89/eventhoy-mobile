package com.losingtime.eventhoy.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import eventhoy.composeapp.generated.resources.Res
import eventhoy.composeapp.generated.resources.jakarta_sans
import eventhoy.composeapp.generated.resources.poppins_regular
import eventhoy.composeapp.generated.resources.poppins_semibold
import org.jetbrains.compose.resources.Font

val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
)

@Composable
 fun poppinsFamily() = FontFamily(
    Font(Res.font.poppins_semibold, FontWeight.SemiBold),
    Font(Res.font.poppins_regular, FontWeight.Normal),
)

data class EventhoyTypo(
    val h0: TextStyle,
    val h1: TextStyle,
    val h2: TextStyle,
    val h3: TextStyle,
    val h4: TextStyle,
    val h5: TextStyle,
    val h6: TextStyle,
    val title: TextStyle,
    val titleM: TextStyle,
    val titleS: TextStyle,
    val buttonL: TextStyle,
    val buttonS: TextStyle,
    val tab: TextStyle,
    val bodyL: TextStyle,
    val bodyS: TextStyle,
    val bodySBold: TextStyle,
    val captionL: TextStyle,
    val captionS: TextStyle,
    val chip: TextStyle,
)

@Composable
 fun jakartaFamily() = FontFamily(
    Font(Res.font.jakarta_sans, weight = FontWeight.Thin, style = FontStyle.Normal),
    Font(Res.font.jakarta_sans, weight = FontWeight.Light, style = FontStyle.Normal),
    Font(Res.font.jakarta_sans, weight = FontWeight.Normal, style = FontStyle.Normal),
    Font(Res.font.jakarta_sans, weight = FontWeight.Medium, style = FontStyle.Normal),
    Font(Res.font.jakarta_sans, weight = FontWeight.SemiBold, style = FontStyle.Normal),
    Font(Res.font.jakarta_sans, weight = FontWeight.Bold, style = FontStyle.Normal),
    Font(Res.font.jakarta_sans, weight = FontWeight.ExtraBold, style = FontStyle.Normal),
)


fun eventhoyTypo(
    poppinsFamily: FontFamily? = null,
    jakartaFamily: FontFamily? = null
): EventhoyTypo {
    val fontFamily = poppinsFamily
    val fontFamilyJakarta = jakartaFamily
    return EventhoyTypo(
        h0 = TextStyle( // H0
            fontFamily = fontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 60.sp,
            lineHeight = 64.sp,
            letterSpacing = 0.sp
        ),
        h1 = TextStyle( // H1
            fontFamily = fontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 48.sp,
            lineHeight = 56.sp,
            letterSpacing = 0.sp
        ),
        h2 = TextStyle( // H2
            fontFamily = fontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 40.sp,
            lineHeight = 48.sp,
            letterSpacing = 0.sp
        ),
        h3 = TextStyle( // H3
            fontFamily = fontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 36.sp,
            lineHeight = 40.sp
        ),
        h4 = TextStyle( // H4
            fontFamily = fontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 32.sp,
            lineHeight = 40.sp
        ),
        h5 = TextStyle( // H5
            fontFamily = fontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 24.sp,
            lineHeight = 32.sp
        ),
        h6 = TextStyle( // H6
            fontFamily = fontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp,
            lineHeight = 24.sp
        ),
        title = TextStyle( // Title
            fontFamily = fontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp,
            lineHeight = 24.sp
        ),
        titleM = TextStyle(
            fontFamily = fontFamilyJakarta,
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
            lineHeight = 24.sp
        ),
        titleS = TextStyle(
            fontFamily = fontFamilyJakarta,
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp,
            lineHeight = 24.sp
        ),
        buttonL = TextStyle(
            fontFamily = fontFamilyJakarta,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            lineHeight = 24.sp
        ),
        buttonS = TextStyle(
            fontFamily = fontFamilyJakarta,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            lineHeight = 24.sp
        ),
        tab = TextStyle(
            fontFamily = fontFamilyJakarta,
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp,
            lineHeight = 24.sp
        ),
        bodyL = TextStyle(
            fontFamily = fontFamilyJakarta,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            lineHeight = 24.sp
        ),
        bodyS = TextStyle(
            fontFamily = fontFamilyJakarta,
            fontWeight = FontWeight.Medium,
            fontSize = 13.sp,
            lineHeight = 24.sp
        ),
        bodySBold = TextStyle(
            fontFamily = fontFamilyJakarta,
            fontWeight = FontWeight.Bold,
            fontSize = 13.sp,
            lineHeight = 20.sp
        ),
        captionL = TextStyle(
            fontFamily = fontFamilyJakarta,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            lineHeight = 16.sp
        ),
        captionS = TextStyle(
            fontFamily = fontFamilyJakarta,
            fontWeight = FontWeight.Medium,
            fontSize = 11.sp,
            lineHeight = 16.sp
        ),
        chip = TextStyle(
            fontFamily = fontFamilyJakarta,
            fontWeight = FontWeight.Medium,
            fontSize = 10.sp,
            lineHeight = 16.sp
        ),
    )
}

