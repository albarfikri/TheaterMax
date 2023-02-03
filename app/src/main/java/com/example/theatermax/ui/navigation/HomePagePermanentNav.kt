package com.example.theatermax.ui.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.theatermax.utils.NavigationItems

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePagePermanentNav(
    currentTab: NavigationItems,
    onTabClicked: (NavigationItems) -> Unit,
    navigationTabList: List<NavigationDestination>,
    modifier: Modifier = Modifier
) {
    PermanentNavigationDrawer(drawerContent = {
        NavigationDrawerContent(
            currentTab = currentTab,
            onTabClicked = onTabClicked,
            navigationTabList = navigationTabList,
            modifier = modifier
        )
    }) {

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationDrawerContent(
    currentTab: NavigationItems,
    onTabClicked: (NavigationItems) -> Unit,
    navigationTabList: List<NavigationDestination>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier
            .wrapContentWidth()
            .fillMaxHeight()
            .background(MaterialTheme.colorScheme.inverseOnSurface)
            .padding(12.dp)
    ) {
        for (navItem in navigationTabList) {
            NavigationDrawerItem(
                label = {
                    Text(text = navItem.route.toString())
                },
                icon = {
                    Icon(
                        imageVector = navItem.icon,
                        contentDescription = navItem.contentDescription
                    )
                },
                selected = currentTab == navItem.route,
                onClick = { onTabClicked(navItem.route) },
                modifier = Modifier.padding(top = 12.dp)
            )
        }
    }
}