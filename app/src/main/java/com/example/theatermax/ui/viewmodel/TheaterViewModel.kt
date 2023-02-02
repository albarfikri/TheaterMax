package com.example.theatermax.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.theatermax.data.TheaterUiState
import com.example.theatermax.utils.NavigationItems
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class TheaterViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(TheaterUiState())
    val uiState: StateFlow<TheaterUiState> = _uiState


    fun updateSelectedItemMenu(itemMenu: NavigationItems) {
        _uiState.update {
            it.copy(
                currentSelectedTab = itemMenu
            )
        }
    }
}