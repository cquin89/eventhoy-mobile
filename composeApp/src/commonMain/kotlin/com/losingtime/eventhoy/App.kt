package com.losingtime.eventhoy

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.losingtime.eventhoy.navigation.EventhoyNavHost
import com.losingtime.eventhoy.presentation.components.EventhoyNavBar
import com.losingtime.eventhoy.presentation.components.NavItem
import com.losingtime.eventhoy.presentation.theme.EventhoyTheme
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication

@Composable
@Preview
fun App(
    navController: NavHostController = rememberNavController()
) {

    val navbarRoutes = listOf(NavItem.Home, NavItem.Favorite, NavItem.Profile)
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: navbarRoutes.first().route.name


    KoinApplication(application = {
        modules(
            platformModule
        )
    }) {
        EventhoyTheme {
            Scaffold(
                bottomBar = {
                    if (currentRoute in navbarRoutes.map { it.route.name }) {
                        EventhoyNavBar(
                            navController = navController,
                            items = navbarRoutes
                        )
                    }
                }) { innerPadding ->

                EventhoyNavHost(
                    navController = navController,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                )
            }
        }
    }
}
