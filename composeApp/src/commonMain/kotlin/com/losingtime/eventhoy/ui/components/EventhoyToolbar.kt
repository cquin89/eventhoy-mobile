package com.losingtime.eventhoy.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil3.compose.AsyncImage
import com.losingtime.eventhoy.ui.theme.EventhoyTheme
import com.losingtime.eventhoy.ui.theme.EventhoyTypo
import com.losingtime.eventhoy.ui.theme.colors
import com.losingtime.eventhoy.ui.theme.eventhoyTypo
import eventhoy.composeapp.generated.resources.Res
import eventhoy.composeapp.generated.resources.arrow_left_rectangle
import eventhoy.composeapp.generated.resources.down_arrow
import eventhoy.composeapp.generated.resources.img
import eventhoy.composeapp.generated.resources.location
import eventhoy.composeapp.generated.resources.notification
import eventhoy.composeapp.generated.resources.search_01
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
    toolbarState: ToolbarState,
    leftClick: (ToolbarState.LeftState) -> Unit = {},
    rightClick: (ToolbarState.RightState) -> Unit = {},
) {
    Column(
        Modifier
            .background(toolbarState.background)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .statusBarsPadding()
                .height(70.dp)
                .padding(horizontal = 24.dp),

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
                        ProfileBar()
                    }
                }
            }

            when (toolbarState.centerState) {
                ToolbarState.CenterState.None -> Unit
                is ToolbarState.CenterState.Title -> {
                    Text(
                        modifier = Modifier.align(Alignment.Center),
                        text = toolbarState.centerState.text,
                        style = eventhoyTypo().title,
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

        // Optional: Search bar below toolbar
        OutlinedTextField(
            value = "",
            leadingIcon = {
                Icon(
                    painter = painterResource(resource = Res.drawable.search_01),
                    contentDescription = "Notification",
                    tint = colors.deactive,
                    modifier = Modifier
                        .size(24.dp)
                        .clickable { rightClick.invoke(ToolbarState.RightState.Notification) }
                )
            },
            onValueChange = {},
            placeholder = {
                Text(
                    text = "Buscar Evento",
                    style = eventhoyTypo().titleM,
                    color = colors.deactive
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp, bottom = 12.dp, top = 6.dp),
            singleLine = true,
            textStyle = eventhoyTypo().titleM
        )
    }


}

@Composable
private fun ProfileBar() {
    Row(verticalAlignment = Alignment.CenterVertically) {
        AsyncImage(
            contentScale = ContentScale.FillBounds,
            error = painterResource(Res.drawable.img),
            model = "https://www.dzoom.org.es/wp-content/uploads/2020/02/portada-foto-perfil-redes-sociales-consejos.jpg",
            contentDescription = "Profile",
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painterResource(Res.drawable.location),
                    contentDescription = null,
                    tint = colors.body,
                    modifier = Modifier.padding(end = 8.dp).size(16.dp)
                )
                Text(
                    "Location",
                    style = eventhoyTypo().titleS,
                    color = colors.body
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                "Los Angeles",
                style = eventhoyTypo().title,
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

@Composable
@Preview()
fun ToolbarDarkThemePreview() {
    EventhoyTheme(darkTheme = true) {
        EventhoyToolbar(
            toolbarState = ToolbarState(
                leftState = ToolbarState.LeftState.Profile("", "Santiago"),
                rightState = ToolbarState.RightState.Notification,
                centerState = ToolbarState.CenterState.None,
                background = colors.background
            ), {}, {})
    }

}

@Composable
@Preview()
fun ToolbarLightThemePreview() {

    EventhoyTheme(darkTheme = false) {
        EventhoyToolbar(
            toolbarState = ToolbarState(
                leftState = ToolbarState.LeftState.Profile("", "Santiago"),
                rightState = ToolbarState.RightState.Notification,
                centerState = ToolbarState.CenterState.None,
                background = MaterialTheme.colorScheme.background
            ), {}, {})
    }

}


@Composable
@Preview()
fun ToolbarWithTitleLightThemePreview() {

    EventhoyTheme(darkTheme = false) {
        EventhoyToolbar(
            toolbarState = ToolbarState(
                leftState = ToolbarState.LeftState.Back,
                rightState = ToolbarState.RightState.Notification,
                centerState = ToolbarState.CenterState.Title("Notificaciones"),
                background = Color.White
            ), {}, {})
    }

}