package com.xemic.composeplayground.ui.common

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun EmptyScreen(
    modifier: Modifier = Modifier,
    message: String
) {
    Box(modifier = modifier
        .fillMaxSize()
    ) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = message
        )
    }
}

@Preview(showBackground = true)
@Composable
fun EmptyScreenPreview() {
    EmptyScreen(
        message = "제품이 존재하지 않습니다."
    )
}