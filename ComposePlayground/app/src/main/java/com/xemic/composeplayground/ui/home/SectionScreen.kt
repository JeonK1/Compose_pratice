package com.xemic.composeplayground.ui.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.xemic.composeplayground.data.ItemInfo
import com.xemic.composeplayground.data.ItemInfoListSample
import com.xemic.composeplayground.ui.common.GridList
import kotlin.random.Random

@Composable
fun SectionScreen(modifier: Modifier = Modifier, currentSection: Section) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        GridList(
            modifier = modifier,
            data = currentSection.itemList
        )
    }
}

data class Section(
    val route: String,
    val itemList: List<ItemInfo>
)