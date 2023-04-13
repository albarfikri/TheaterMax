package com.example.theatermax.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.theatermax.utils.NavigationItems

interface NavigationDestination {
    val icon: ImageVector
    val route: NavigationItems
    val contentDescription: String
}

object Home : NavigationDestination {
    override val icon = Icons.Default.Home
    override val route = NavigationItems.HOME
    override val contentDescription = "Home"
}

object Trending : NavigationDestination {
    override val icon = Icons.Default.Star
    override val route = NavigationItems.TRENDING
    override val contentDescription = "Trending"
}

object TvShow : NavigationDestination {
    override val icon = Icons.Default.List
    override val route = NavigationItems.TVSHOW
    override val contentDescription = "Tv Show"
}

val theaterTab = listOf(Home, Trending, TvShow)