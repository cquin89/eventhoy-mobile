package com.losingtime.eventhoy.presentation.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImage
import com.losingtime.eventhoy.presentation.components.EventhoyToolbar
import com.losingtime.eventhoy.presentation.components.ToolbarState
import com.losingtime.eventhoy.presentation.theme.EventhoyTheme
import com.losingtime.eventhoy.presentation.theme.colors
import com.losingtime.eventhoy.presentation.theme.dimens
import com.losingtime.eventhoy.presentation.theme.typos
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeScreen(onEventClicked: () -> Unit) {
        val viewModel: HomeViewModel = koinViewModel()
        val uiState by viewModel.uiState.collectAsState()

        Column(
                modifier =
                        Modifier.fillMaxSize()
                                .background(colors.background)
                                .padding(
                                        start = dimens.dp16,
                                        top = dimens.dp16,
                                        bottom = dimens.dp16
                                )
        ) {
                Text(
                        modifier = Modifier.padding(bottom = dimens.dp12),
                        text = "Eventhoy",
                        style = typos.title,
                        fontWeight = FontWeight.Bold
                )

                Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                        EventhoyToolbar(
                                modifier =
                                        Modifier.fillMaxWidth()
                                                .padding(bottom = 15.dp, end = 24.dp),
                                toolbarState =
                                        ToolbarState(
                                                leftState =
                                                        ToolbarState.LeftState.Profile(
                                                                "",
                                                                "Santiago"
                                                        ),
                                                rightState = ToolbarState.RightState.None,
                                                centerState = ToolbarState.CenterState.None,
                                                background = colors.background
                                        ),
                                leftClick = {},
                                rightClick = {},
                                onLocationClick = {}
                        )

                        // Categories
                        Text(
                                "Categorias",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(8.dp))

                        when {
                                uiState.isLoading -> {
                                        Box(
                                                modifier = Modifier.fillMaxWidth().height(60.dp),
                                                contentAlignment = Alignment.Center
                                        ) { CircularProgressIndicator() }
                                }
                                uiState.error != null -> {
                                        Box(
                                                modifier = Modifier.fillMaxWidth().height(60.dp),
                                                contentAlignment = Alignment.Center
                                        ) {
                                                Column(
                                                        horizontalAlignment =
                                                                Alignment.CenterHorizontally
                                                ) {
                                                        Text(
                                                                text = uiState.error
                                                                                ?: "Error desconocido",
                                                                color = Color.Red,
                                                                style =
                                                                        MaterialTheme.typography
                                                                                .bodySmall
                                                        )
                                                        Spacer(modifier = Modifier.height(8.dp))
                                                        Button(
                                                                onClick = {
                                                                        viewModel
                                                                                .retryLoadCategories()
                                                                }
                                                        ) { Text("Reintentar") }
                                                }
                                        }
                                }
                                else -> {
                                        LazyRow(
                                                horizontalArrangement = Arrangement.spacedBy(12.dp)
                                        ) {
                                                items(uiState.categories) { category ->
                                                        Box(
                                                                modifier =
                                                                        Modifier.size(
                                                                                        width =
                                                                                                120.dp,
                                                                                        height =
                                                                                                60.dp
                                                                                )
                                                                                .clip(
                                                                                        RoundedCornerShape(
                                                                                                12.dp
                                                                                        )
                                                                                )
                                                                                .background(
                                                                                        Color(
                                                                                                0xFFEEEEEE
                                                                                        )
                                                                                ),
                                                                contentAlignment = Alignment.Center
                                                        ) {
                                                                Text(
                                                                        category.name,
                                                                        style =
                                                                                MaterialTheme
                                                                                        .typography
                                                                                        .bodyMedium,
                                                                        textAlign = TextAlign.Center
                                                                )
                                                        }
                                                }
                                        }
                                }
                        }

                        Spacer(modifier = Modifier.height(24.dp))

                        // Upcoming Events
                        Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                                Text(
                                        "Upcoming Event",
                                        style = MaterialTheme.typography.titleMedium,
                                        fontWeight = FontWeight.Bold
                                )
                                Text(
                                        "See all",
                                        color = Color.Gray,
                                        style = MaterialTheme.typography.bodySmall
                                )
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                                item {
                                        EventCard(
                                                title = "Coachella Valley Music and Arts Festival",
                                                location = "Indio, CA",
                                                date = "Feb 14-16 & 21-23",
                                                price = "$549",
                                                imageUrl = "imageUrl"
                                        )
                                }
                                item {
                                        EventCard(
                                                title = "New York Parade",
                                                location = "New York, NY",
                                                date = "March 5",
                                                price = "$299",
                                                imageUrl =
                                                        "https://images.unsplash.com/photo-1514525253161-7a46d19cd819?fm=jpg&q=60&w=3000&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8N3x8Y29uY2llcnRvfGVufDB8fDB8fHww"
                                        )
                                }
                        }

                        Spacer(modifier = Modifier.height(24.dp))

                        // Suggestions
                        Text(
                                "Suggestion For You",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        EventCard(
                                title = "Electronic Music – Ultra Music Festival",
                                location = "Miami, FL",
                                date = "March 20",
                                price = "$399",
                                imageUrl =
                                        "https://images.unsplash.com/photo-1514525253161-7a46d19cd819?fm=jpg&q=60&w=3000&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8N3x8Y29uY2llcnRvfGVufDB8fDB8fHww"
                        )
                }
        }
}

@Composable
fun EventCard(title: String, location: String, date: String, price: String, imageUrl: String) {
        Column(
                modifier =
                        Modifier.width(220.dp)
                                .clip(RoundedCornerShape(16.dp))
                                .background(Color.White)
                                .shadow(4.dp, RoundedCornerShape(16.dp))
        ) {
                AsyncImage(
                        model = imageUrl,
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.height(140.dp).fillMaxWidth()
                )
                Column(modifier = Modifier.padding(12.dp)) {
                        Text(
                                title,
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.Bold,
                                maxLines = 2
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                                location,
                                style = MaterialTheme.typography.bodySmall,
                                color = Color.Gray
                        )
                        Text(date, style = MaterialTheme.typography.bodySmall, color = Color.Gray)
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                                "Starting at $price",
                                style = MaterialTheme.typography.bodySmall,
                                fontWeight = FontWeight.Bold
                        )
                }
        }
}

@Composable
@Preview()
fun EventHomeScreenPreview() {

        EventhoyTheme(darkTheme = false) { HomeScreen({}) }
}
