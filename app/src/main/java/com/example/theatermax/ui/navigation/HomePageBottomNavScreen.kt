package com.example.theatermax.ui.navigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import com.example.theatermax.data.TheaterUiState
import com.example.theatermax.ui.navigation.NavigationDestination
import com.example.theatermax.utils.DisabledInteractionSource
import com.example.theatermax.utils.NavigationItems
import com.example.theatermax.utils.StyleUtils
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow


@Composable
fun HomePageBottomNavBar(
    currentTab: NavigationItems,
    onTabClicked: (NavigationItems) -> Unit,
    navigationTabList: List<NavigationDestination>,
    modifier: Modifier = Modifier
) {
    val disableInteraction = remember { StyleUtils.DisabledInteractionSource }
    NavigationBar(
        modifier = modifier.fillMaxWidth()
    ) {
        for (navItem in navigationTabList) {
            NavigationBarItem(
                selected = currentTab == navItem.route,
                onClick = {
                    onTabClicked(navItem.route)
                },
                icon = {
                    Icon(
                        imageVector = navItem.icon, contentDescription = navItem.contentDescription
                    )
                },
                label = {
                    Text(
                        text = navItem.route.toString(),
                        style = MaterialTheme.typography.labelMedium
                    )
                },
                interactionSource = disableInteraction
            )
        }
    }
}
