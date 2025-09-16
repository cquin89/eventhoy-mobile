package com.losingtime.eventhoy.ui.screen.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen() {

    Column(
        modifier = Modifier.fillMaxSize().background(Color.LightGray)
    ) {
        Text(
            text = "welcome to login screen",
            fontSize = 25.sp
        )
        Button(
            onClick = {
            }
        ) {
            Text("go to favorite")
        }
    }
}