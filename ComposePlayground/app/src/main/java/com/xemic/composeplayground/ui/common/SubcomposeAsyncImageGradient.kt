package com.xemic.composeplayground.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import coil.compose.SubcomposeAsyncImage
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale

@Composable
fun SubcomposeAsyncImageGradient(
    model: String,
    contentDescription: String,
    contentScale: ContentScale,
    brush: Brush,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier
        .width(IntrinsicSize.Min)
        .height(IntrinsicSize.Min)) {
        SubcomposeAsyncImage(
            model = model,
            contentDescription = contentDescription,
            contentScale = contentScale,
            modifier = modifier
        )
        Box(modifier = Modifier
            .fillMaxSize()
            .background(
                brush = brush,
                shape = RectangleShape,
                alpha = 0.5f
            ))
    }
}