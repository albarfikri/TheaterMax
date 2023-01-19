package com.example.theatermax

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import com.example.theatermax.ui.TheaterMaxApp
import com.example.theatermax.ui.theme.TheaterMaxTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TheaterMaxTheme {
                val windowsSize = calculateWindowSizeClass(activity = this)
                TheaterMaxApp(
                    windowSize = windowsSize.widthSizeClass
                )
            }
        }
    }
}
