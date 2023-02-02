package com.example.theatermax.ui

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.theatermax.ui.navigation.NavigationDestination
import com.example.theatermax.ui.navigation.theaterTab
import com.example.theatermax.ui.viewmodel.TheaterViewModel
import com.example.theatermax.utils.TheaterMaxNavigationType


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

    TheaterMainScreen(theaterUiState = theaterUiState,
        navigationType = navigationType,
        navigationTabList = theaterTab,
        onTabClicked = { navItem ->
            viewModel.updateSelectedItemMenu(navItem)
        })
}


@Composable
@Preview(showSystemUi = true)
fun DefaultPreview() {
    TheaterMaxApp(windowSize = WindowWidthSizeClass.Compact)
}
