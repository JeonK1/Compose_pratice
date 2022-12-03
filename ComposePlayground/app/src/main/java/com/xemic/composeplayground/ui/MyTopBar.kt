package com.xemic.composeplayground.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MyTopBar(currentScreen: Destination) {
    Text(
        text = currentScreen.name,
        textAlign = TextAlign.Center,
        modifier = Modifier.fillMaxWidth()
    )
}
@Preview(showBackground = true)
@Composable
fun MyTopBarPreview() {
    MyTopBar(Destination.Home)
}
