package com.losingtime.eventhoy.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.losingtime.eventhoy.ui.theme.colors
import com.losingtime.eventhoy.ui.theme.eventhoyTypo
import eventhoy.composeapp.generated.resources.Res
import eventhoy.composeapp.generated.resources.search_01
import org.jetbrains.compose.resources.painterResource

@Composable
fun SeachBar() {
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
                    .clickable { }
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