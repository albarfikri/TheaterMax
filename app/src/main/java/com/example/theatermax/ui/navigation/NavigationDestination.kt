package com.example.theatermax.ui.navigation

import android.graphics.drawable.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector

interface NavigationDestination {
    val icon: ImageVector
    val route: String
    val contentDescription: String
}

object Home : NavigationDestination {
    override val icon = Icons.Filled.Home
    override val route = "homeDestination"
    override val contentDescription = "Home"
}

object Trending : NavigationDestination {
    override val icon = Icons.Filled.Star
    override val route = "trendingDestination"
    override val contentDescription = "Trending"
}

object TvShow : NavigationDestination {
    override val icon = Icons.Filled.List
    override val route = "tvShowDestination"
    override val contentDescription = "Tv Show"
}

val theaterTab = listOf(Home, Trending, TvShow)