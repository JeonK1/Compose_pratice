package com.xemic.composeplayground.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

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