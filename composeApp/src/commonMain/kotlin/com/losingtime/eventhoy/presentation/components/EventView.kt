package com.losingtime.eventhoy.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import com.losingtime.eventhoy.presentation.theme.EventhoyTheme
import eventhoy.composeapp.generated.resources.Res
import eventhoy.composeapp.generated.resources.img
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun EventView(modifier: Modifier = Modifier) {


}


@Composable
@Preview()
fun EventViewLightThemePreview() {

    EventhoyTheme(darkTheme = false) {
        EventView()
    }

}