package com.xemic.composeplayground.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HomeSuccess(
    modifier: Modifier = Modifier,
    currentSection: Section,
    onSectionChanged: (Int) -> Unit,
    sectionList: List<Section>,
    scrollState: LazyGridState
) {
    Column {
        TopSectionBar(
            allSections = sectionList,
            onTabSelected = { index ->
                onSectionChanged(index)
            },
            currentScreen = currentSection
        )

        SectionScreen(
            modifier = modifier,
            currentSection = currentSection,
            scrollState = scrollState
        )
    }
}