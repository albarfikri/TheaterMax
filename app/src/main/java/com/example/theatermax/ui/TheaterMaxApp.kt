package com.example.theatermax.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.theatermax.ui.navigation.*
import com.example.theatermax.ui.viewmodel.TheaterViewModel
import com.example.theatermax.utils.TheaterMaxNavigationType


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TheaterMaxApp(
    windowSize: WindowWidthSizeClass, modifier: Modifier = Modifier
) {
    val viewModel: TheaterViewModel = viewModel()
    val theaterUiState = viewModel.uiState.collectAsState().value

    val navigationType: TheaterMaxNavigationType = when (windowSize) {
        WindowWidthSizeClass.Compact -> {
            TheaterMaxNavigationType.BOTTOM_NAVIGATION
        }
        WindowWidthSizeClass.Medium -> {
            TheaterMaxNavigationType.NAVIGATION_RAIL
        }
        WindowWidthSizeClass.Expanded -> {
            TheaterMaxNavigationType.PERMANENT_NAVIGATION
        }
        else -> TheaterMaxNavigationType.BOTTOM_NAVIGATION
    }

    val navController = rememberNavController()

    val currentBackStack by navController.currentBackStackEntryAsState()

    // fetch current Destination
    val currentDestination = currentBackStack?.destination

    Scaffold(bottomBar = {
        AnimatedVisibility(visible = navigationType == TheaterMaxNavigationType.BOTTOM_NAVIGATION) {
            HomePageBottomNavBar(
                currentTab = theaterUiState.currentSelectedTab, onTabClicked = { navItem ->
                    viewModel.updateSelectedItemMenu(navItem)
                }, navigationTabList = theaterTab
            )
        }
    }) { innerPadding ->
        Row(modifier = modifier.fillMaxSize()) {
            AnimatedVisibility(visible = navigationType == TheaterMaxNavigationType.PERMANENT_NAVIGATION) {
                HomePagePermanentNav()
            }
            AnimatedVisibility(visible = navigationType == TheaterMaxNavigationType.NAVIGATION_RAIL) {
                HomePageRailNav()
            }
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.inverseOnSurface)
            ) {
                TheaterNavHost(
                    navController = navController, modifier = Modifier.padding(innerPadding)
                )
            }
        }
    }
}


@Composable
@Preview(showSystemUi = true)
fun DefaultPreview() {
    TheaterMaxApp(windowSize = WindowWidthSizeClass.Compact)
}
