package com.example.theatermax.ui.navigation.bottomnav

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.theatermax.ui.navigation.NavigationDestination

@Composable
fun HomePageBottomNavScreen(
    onTabClicked: (String) -> Unit,
    navigationTabList: List<NavigationDestination>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {

        TheaterBottomNavigationBar(
            onTabClicked,
            navigationTabList
        )
    }
}



@Composable
fun TheaterBottomNavigationBar(
    onTabClicked: (String) -> Unit,
    navigationTabList: List<NavigationDestination>,
    modifier: Modifier = Modifier
) {
    NavigationBar(
        modifier = modifier.fillMaxWidth()
    ) {
        for (navItem in navigationTabList) {
            NavigationBarItem(
                selected = true,
                onClick = { /*TODO*/ },
                icon = {
                    Icon(
                        imageVector = navItem.icon,
                        contentDescription = navItem.contentDescription
                    )
                }
            )
        }
    }
}