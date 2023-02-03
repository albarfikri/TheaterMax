package com.example.theatermax.ui.navigation

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.theatermax.utils.NavigationItems
import com.example.theatermax.utils.StyleUtils

@Composable
fun HomePageRailNav(
    currentTab: NavigationItems,
    onTabClicked: (NavigationItems) -> Unit,
    navigationTabList: List<NavigationDestination>,
    modifier: Modifier = Modifier
) {
    val disabledInteractionSource = remember { StyleUtils.DisabledInteractionSource }
    NavigationRail(modifier.fillMaxHeight()) {
        for (navItem in navigationTabList) {
            NavigationRailItem(
                selected = currentTab == navItem.route,
                onClick = {
                    onTabClicked(navItem.route)
                },
                icon = {
                    Icon(
                        imageVector = navItem.icon,
                        contentDescription = navItem.contentDescription
                    )
                },
                interactionSource = disabledInteractionSource
            )
        }
    }
}
