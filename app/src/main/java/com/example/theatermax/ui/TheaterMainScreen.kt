package com.example.theatermax.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.theatermax.ui.navigation.bottomnav.HomePageBottomNavScreen
import com.example.theatermax.ui.navigation.NavigationDestination
import com.example.theatermax.ui.navigation.permanentnav.HomePagePermanentNav
import com.example.theatermax.ui.navigation.railnav.HomePageRailNav
import com.example.theatermax.utils.TheaterMaxNavigationType

@Composable
fun TheaterMainScreen(
    navigationType: TheaterMaxNavigationType,
    navigationTabList: List<NavigationDestination>,
    onTabClicked: (String) -> Unit,
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
            modifier = modifier.fillMaxSize()
        ) {
            TheaterHomeContent(
                modifier = Modifier.weight(1f)
            )
            AnimatedVisibility(visible = navigationType == TheaterMaxNavigationType.BOTTOM_NAVIGATION) {
                HomePageBottomNavScreen(
                    onTabClicked = onTabClicked,
                    navigationTabList = navigationTabList,
                )
            }
        }
    }
}