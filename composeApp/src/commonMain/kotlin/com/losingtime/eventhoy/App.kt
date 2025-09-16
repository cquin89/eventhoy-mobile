package com.losingtime.eventhoy

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.losingtime.eventhoy.navigation.EventhoyNavHost
import com.losingtime.eventhoy.navigation.EventhoyScreen
import com.losingtime.eventhoy.ui.components.EventhoyNavBar
import com.losingtime.eventhoy.ui.components.EventhoyToolbar
import com.losingtime.eventhoy.ui.components.NavItem
import com.losingtime.eventhoy.ui.components.ToolbarState
import com.losingtime.eventhoy.ui.screen.home.HomeViewModel
import com.losingtime.eventhoy.ui.theme.EventhoyTheme
import com.losingtime.eventhoy.ui.theme.colors
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication

@Composable
@Preview
fun App(
    viewModel: HomeViewModel = viewModel { HomeViewModel() },
    navController: NavHostController = rememberNavController()
) {
    // Get current back stack entry
    val backStackEntry by navController.currentBackStackEntryAsState()
    // Get the name of the current screen
    val currentScreen = EventhoyScreen.valueOf(
        backStackEntry?.destination?.route ?: EventhoyScreen.Home.name
    )


    KoinApplication(application = {
        modules(
            platformModule
        )
    }) {
        EventhoyTheme {
            Scaffold(
                topBar = {

                    EventhoyToolbar(
                        toolbarState = ToolbarState(
                            leftState = ToolbarState.LeftState.Profile("", "Santiago"),
                            rightState = ToolbarState.RightState.Notification,
                            centerState = ToolbarState.CenterState.None,
                            background = colors.background
                        ), {}, {})
                },
                bottomBar = {
                    EventhoyNavBar(
                        navController = navController,
                        listOf(NavItem.Home, NavItem.Favorite, NavItem.Profile)
                    )
                }) {

                    innerPadding ->
                val uiState by viewModel.uiState.collectAsState()

                EventhoyNavHost(
                    navController, Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                        .padding(innerPadding)
                )
            }
        }
    }
}
