package com.example.theatermax.ui

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.theatermax.ui.bottomnav.HomePageBottomNavScreen
import com.example.theatermax.ui.permanentnav.HomePagePermanentNav
import com.example.theatermax.ui.railnav.HomePageRailNav
import com.example.theatermax.utils.TheaterMaxNavigationType

@Composable
fun TheaterMainScreen(
    navigationType: TheaterMaxNavigationType,
    modifier: Modifier = Modifier
) {
    when (navigationType) {
        TheaterMaxNavigationType.BOTTOM_NAVIGATION -> {
            HomePageBottomNavScreen(

            )
        }
        TheaterMaxNavigationType.NAVIGATION_RAIL -> {
            Text(text = TheaterMaxNavigationType.NAVIGATION_RAIL.toString())
            HomePageRailNav()
        }
        else -> {
            Text(text = TheaterMaxNavigationType.PERMANENT_NAVIGATION.toString())
            HomePagePermanentNav()
        }
    }
}