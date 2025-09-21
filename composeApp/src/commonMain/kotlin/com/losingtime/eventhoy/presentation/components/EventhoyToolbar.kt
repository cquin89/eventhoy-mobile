package com.losingtime.eventhoy.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.losingtime.eventhoy.presentation.theme.EventhoyTheme
import com.losingtime.eventhoy.presentation.theme.colors
import com.losingtime.eventhoy.presentation.theme.typos
import eventhoy.composeapp.generated.resources.Res
import eventhoy.composeapp.generated.resources.arrow_left_rectangle
import eventhoy.composeapp.generated.resources.down_arrow
import eventhoy.composeapp.generated.resources.location
import eventhoy.composeapp.generated.resources.notification
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

data class ToolbarState(
    val leftState: LeftState,
    val centerState: CenterState,
    val rightState: RightState,
    val background: Color
) {
    sealed class LeftState() {
        data class Profile(val imageUrl: String, val location: String) : LeftState()
        object Back : LeftState()
        object None : LeftState()
    }

    sealed class CenterState() {
        data class Title(val text: String) : CenterState()
        object None : CenterState()
    }

    sealed class RightState() {
        object Notification : RightState()
        object Delete : RightState()
        object None : RightState()
    }
}

@Composable
fun EventhoyToolbar(
    modifier: Modifier = Modifier,
    toolbarState: ToolbarState,
    leftClick: (ToolbarState.LeftState) -> Unit = {},
    rightClick: (ToolbarState.RightState) -> Unit = {},
    onLocationClick: () -> Unit
) {

    Box(
        modifier = modifier.height(55.dp).background(toolbarState.background),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.align(Alignment.CenterStart)
        ) {
            when (toolbarState.leftState) {
                ToolbarState.LeftState.Back -> {
                    Icon(
                        painter = painterResource(Res.drawable.arrow_left_rectangle),
                        contentDescription = "Back",
                        tint = colors.text,
                        modifier = Modifier
                            .size(24.dp)
                            .clickable { leftClick.invoke(ToolbarState.LeftState.Back) }
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                }

                ToolbarState.LeftState.None -> Unit

                is ToolbarState.LeftState.Profile -> {

                    ProfileBar(
                        location = toolbarState.leftState.location,
                        onLocationClick = onLocationClick
                    )
                }

            }
        }


        when (toolbarState.centerState) {
            ToolbarState.CenterState.None -> Unit
            is ToolbarState.CenterState.Title -> {
                Text(
                    modifier = Modifier.align(Alignment.Center),
                    text = toolbarState.centerState.text,
                    style = typos.title,
                    color = colors.text
                )
            }

        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.align(Alignment.CenterEnd)
        ) {
            when (toolbarState.rightState) {
                ToolbarState.RightState.Delete -> {
                    Icon(
                        painter = painterResource(resource = Res.drawable.location),
                        contentDescription = "Delete",
                        modifier = Modifier
                            .size(24.dp)
                            .clickable { rightClick.invoke(ToolbarState.RightState.Delete) }
                    )
                }

                ToolbarState.RightState.None -> Unit

                ToolbarState.RightState.Notification -> {
                    Icon(
                        painter = painterResource(resource = Res.drawable.notification),
                        contentDescription = "Notification",
                        tint = colors.text,
                        modifier = Modifier
                            .size(24.dp)
                            .clickable { rightClick.invoke(ToolbarState.RightState.Notification) }
                    )
                }
            }
        }

    }
}

@Composable
private fun ProfileBar(
    modifier: Modifier = Modifier,
    location: String,
    onLocationClick: () -> Unit
) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Icon(
            painterResource(Res.drawable.location),
            contentDescription = null,
            tint = colors.text,
            modifier = Modifier.size(40.dp)
                .border(
                    width = 2.dp,             // grosor de la línea
                    color = colors.body,        // color de la línea
                    shape = CircleShape       // forma circular
                )
                .padding(10.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.clickable {
            onLocationClick.invoke()
        }) {
            Column {
                Row(verticalAlignment = Alignment.CenterVertically) {

                    Text(
                        "Ubicacion",
                        style = typos.titleS,
                        color = colors.body
                    )
                }
                Text(
                    location,
                    style = typos.title,
                    fontWeight = FontWeight.Bold,
                    color = colors.text
                )


            }
            Spacer(modifier = Modifier.width(8.dp))
            Icon(
                painterResource(Res.drawable.down_arrow),
                contentDescription = null,
                tint = colors.text,
                modifier = Modifier.size(16.dp)
            )
        }
    }
}

@Composable
@Preview()
fun ToolbarDarkThemePreview() {
    EventhoyTheme(darkTheme = true) {
        EventhoyToolbar(
            modifier = Modifier.fillMaxWidth(),
            toolbarState = ToolbarState(
                leftState = ToolbarState.LeftState.Profile("", "Santiago"),
                rightState = ToolbarState.RightState.Notification,
                centerState = ToolbarState.CenterState.None,
                background = colors.background
            ), leftClick = {}, rightClick = {}, onLocationClick = {})
    }

}

@Composable
@Preview()
fun ToolbarLightThemePreview() {

    EventhoyTheme(darkTheme = false) {
        EventhoyToolbar(
            modifier = Modifier.fillMaxWidth(),
            toolbarState = ToolbarState(
                leftState = ToolbarState.LeftState.Profile("", "Santiago"),
                rightState = ToolbarState.RightState.Notification,
                centerState = ToolbarState.CenterState.None,
                background = colors.background
            ), leftClick = {}, rightClick = {}, onLocationClick = {})
    }

}

@Composable
@Preview()
fun ToolbarWithTitleDarkThemePreview() {

    EventhoyTheme(darkTheme = true) {
        EventhoyToolbar(
            modifier = Modifier.fillMaxWidth(),
            toolbarState = ToolbarState(
                leftState = ToolbarState.LeftState.Back,
                rightState = ToolbarState.RightState.Notification,
                centerState = ToolbarState.CenterState.Title("Notificaciones"),
                background = colors.background
            ), leftClick = {}, rightClick = {}, onLocationClick = {})
    }

}

@Composable
@Preview()
fun ToolbarWithTitleLightThemePreview() {

    EventhoyTheme(darkTheme = false) {
        EventhoyToolbar(
            modifier = Modifier.fillMaxWidth(),
            toolbarState = ToolbarState(
                leftState = ToolbarState.LeftState.Back,
                rightState = ToolbarState.RightState.Notification,
                centerState = ToolbarState.CenterState.Title("Notificaciones"),
                background = colors.background
            ), leftClick = {}, rightClick = {}, onLocationClick = {})
    }

}

