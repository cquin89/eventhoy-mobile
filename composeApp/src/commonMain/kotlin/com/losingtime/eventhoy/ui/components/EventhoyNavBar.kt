package com.losingtime.eventhoy.ui.components

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.losingtime.eventhoy.navigation.EventhoyScreen
import com.losingtime.eventhoy.ui.theme.EventhoyTheme
import com.losingtime.eventhoy.ui.theme.colors
import eventhoy.composeapp.generated.resources.Res
import eventhoy.composeapp.generated.resources.bookmark
import eventhoy.composeapp.generated.resources.home_04
import eventhoy.composeapp.generated.resources.user_rectangle
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

sealed class NavItem(
    val route: EventhoyScreen,
    val label: String,
    val icon: DrawableResource,
    val iconSelected: DrawableResource
) {
    object Home : NavItem(EventhoyScreen.Home, "Home", Res.drawable.home_04,Res.drawable.home_04)
    object Favorite : NavItem(EventhoyScreen.Favorite, "Favoritos", Res.drawable.bookmark,Res.drawable.bookmark)
    object Profile : NavItem(EventhoyScreen.Profile, "Editar Perfil", Res.drawable.user_rectangle,Res.drawable.user_rectangle)
}


@Composable
fun EventhoyNavBar(navController: NavHostController, items: List<NavItem>) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: items.first().route.name

    NavigationBar(
        containerColor = colors.background
    ) {
        items.forEach { item ->
            val selected = currentRoute == item.route.name
            NavigationBarItem(
                icon = {
                    Icon(
                        painterResource(if (selected) item.iconSelected else item.icon),
                        contentDescription = item.label
                    )
                },
                selected = selected,
                onClick = {
                    // Navegación con comportamiento "singleTop" y preservando estado
                    navController.navigate(item.route.name) {
                        // evita múltiples instancias
                        launchSingleTop = true
                        // vuelve a la ruta de inicio del grafo de nav para limpiar hasta ella si queremos
                        restoreState = true
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = colors.systemOrange,   // color relleno cuando está seleccionado
                    unselectedIconColor = colors.body,
                    indicatorColor = Color.Transparent,
                )
            )
        }
    }
}

@Composable
@Preview()
fun BottomNavigationBarDarkThemePreview(navController: NavHostController = rememberNavController()) {
    EventhoyTheme(darkTheme = true) {
        EventhoyNavBar(navController, listOf(NavItem.Home, NavItem.Favorite, NavItem.Profile))
    }

}

@Composable
@Preview()
fun BottomNavigationBarLightThemePreview(navController: NavHostController = rememberNavController()) {

    EventhoyTheme(darkTheme = false) {
        EventhoyNavBar(navController, listOf(NavItem.Home, NavItem.Favorite, NavItem.Profile))
    }

}