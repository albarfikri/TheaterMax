package com.example.theatermax.ui.navigation

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.theatermax.utils.NavigationItems
import com.example.theatermax.utils.StyleUtils

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun HomePageBottomNavBar(
    currentTab: NavigationItems,
    onTabClicked: (NavigationItems) -> Unit,
    navigationTabList: List<NavigationDestination>,
    modifier: Modifier = Modifier
) {
    val disableInteraction = remember { StyleUtils.DisabledInteractionSource }
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.primary,
        modifier = modifier
            .fillMaxWidth()
    ) {
        for (navItem in navigationTabList) {
            val changedTextColor by animateColorAsState(
                if (currentTab == navItem.route) MaterialTheme.colorScheme.onSurface else
                    MaterialTheme.colorScheme.onPrimary
            )

            val changedIconColor by animateColorAsState(
                if(currentTab == navItem.route) MaterialTheme.colorScheme.onSecondary else
                    MaterialTheme.colorScheme.onPrimary
            )

            NavigationBarItem(
                selected = currentTab == navItem.route,
                onClick = {
                    onTabClicked(navItem.route)
                },
                icon = {
                    Icon(
                        imageVector = navItem.icon,
                        contentDescription = navItem.contentDescription,
                        tint = changedIconColor
                    )
                },
                label = {
                    Text(
                        text = navItem.contentDescription,
                        color = changedTextColor,
                        fontSize = if(currentTab == navItem.route) 14.sp else 12.sp,
                        style = if(currentTab==navItem.route)MaterialTheme.typography.labelLarge else
                            MaterialTheme.typography.labelMedium,
                        modifier = modifier.animateContentSize(animationSpec = spring(dampingRatio = Spring.DampingRatioLowBouncy, stiffness = Spring.StiffnessLow))
                    )
                },
                interactionSource = disableInteraction,
            )
        }
    }
}
