package com.example.theatermax.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.theatermax.ui.screens.home.HomeScreen
import com.example.theatermax.ui.screens.trending.TrendingScreen
import com.example.theatermax.ui.screens.tvshow.TvShowScreen
import com.example.theatermax.utils.NavigationItems


fun NavigationDestination.route(): String {
    return this.route.toString()
}


@Composable
fun TheaterNavHost(
    navController: NavHostController, modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController, startDestination = Home.route(), modifier = modifier
    ) {
        composable(route = Home.route()) {
            HomeScreen()
        }

        composable(route = Trending.route()) {
            TrendingScreen()
        }

        composable(route = TvShow.route()) {
            TvShowScreen()
        }
    }
}

