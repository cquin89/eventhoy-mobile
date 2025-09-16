package com.losingtime.eventhoy.navigation

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.losingtime.eventhoy.ui.screen.detail.EventDetailScreen
import com.losingtime.eventhoy.ui.screen.favorite.FavoriteScreen
import com.losingtime.eventhoy.ui.screen.home.HomeScreen
import com.losingtime.eventhoy.ui.screen.login.LoginScreen
import com.losingtime.eventhoy.ui.screen.profile.ProfileScreen
import com.losingtime.eventhoy.ui.theme.colors

@Composable
fun EventhoyNavHost(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = EventhoyScreen.Home.name,
        modifier = modifier.background(colors.background)
    ) {
        composable(route = EventhoyScreen.Home.name) {
            HomeScreen(onEventClicked = {
                navController.navigate(EventhoyScreen.EventDetail)
            })
        }
        composable(route = EventhoyScreen.Login.name) {
            LoginScreen(
            )
        }
        composable(route = EventhoyScreen.EventDetail.name) {
            EventDetailScreen()
        }
        composable(route = EventhoyScreen.Favorite.name) {
            FavoriteScreen()
        }
        composable(route = EventhoyScreen.Profile.name) {
            ProfileScreen()
        }
    }
}