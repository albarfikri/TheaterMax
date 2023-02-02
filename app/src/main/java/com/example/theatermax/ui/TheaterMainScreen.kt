package com.example.theatermax.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.theatermax.data.TheaterUiState
import com.example.theatermax.ui.navigation.HomePageBottomNavBar
import com.example.theatermax.ui.navigation.HomePagePermanentNav
import com.example.theatermax.ui.navigation.HomePageRailNav
import com.example.theatermax.ui.navigation.NavigationDestination
import com.example.theatermax.utils.NavigationItems
import com.example.theatermax.utils.TheaterMaxNavigationType

@Composable
fun TheaterMainScreen(
    theaterUiState: TheaterUiState,
    navigationType: TheaterMaxNavigationType,
    navigationTabList: List<NavigationDestination>,
    onTabClicked: (NavigationItems) -> Unit,
    modifier: Modifier = Modifier
) {
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
            TheaterHomeContent(
                modifier = Modifier.weight(1f)
            )
            AnimatedVisibility(visible = navigationType == TheaterMaxNavigationType.BOTTOM_NAVIGATION) {
                HomePageBottomNavBar(
                    currentTab = theaterUiState.currentSelectedTab,
                    onTabClicked = onTabClicked,
                    navigationTabList = navigationTabList,
                )
            }
        }
    }
}