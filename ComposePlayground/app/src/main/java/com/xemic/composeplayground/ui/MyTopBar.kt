package com.xemic.composeplayground.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.xemic.composeplayground.common.theme.Gray900

@Composable
fun MyTopBar(currentScreen: CommonNavigateItem) {
    Text(
        text = currentScreen.appBarName,
        textAlign = TextAlign.Center,
        fontSize = 18.sp,
        color = Gray900,
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
    )
}
@Preview(showBackground = true)
@Composable
fun MyTopBarPreview() {
    MyTopBar(BottomNavigateItem.Home)
}
