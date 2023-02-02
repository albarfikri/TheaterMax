package com.example.theatermax.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.theatermax.ui.theme.TheaterMaxTheme

@Composable
fun TheaterHomeContent(
    modifier: Modifier = Modifier
) {
    TrendingPhotosList(photos = listOf(1, 2, 3, 4, 4))
}

@Composable
fun TrendingPhotosList(
    photos: List<Int>,
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = modifier.fillMaxWidth().height(120.dp),
        contentPadding = PaddingValues(4.dp)
    ) {
        items(items = photos) {
            TrendingPhotoCard(photo = it)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TrendingPhotoCard(
    photo: Int,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .padding(4.dp)
            .aspectRatio(1f),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        )
    ) {
        Text(text = "Test $photo")
    }
}


@Preview()
@Composable
fun ResultPreview() {
    TheaterMaxTheme {
        TheaterHomeContent()
    }
}