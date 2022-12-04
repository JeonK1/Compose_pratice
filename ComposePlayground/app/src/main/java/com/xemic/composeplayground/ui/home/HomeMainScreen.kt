package com.xemic.composeplayground.ui.home

import HomeSuccess
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier

@Composable
fun HomeMainScreen(
    modifier: Modifier = Modifier,
    uiState: HomeViewModel.UiState,
    scrollState: LazyGridState,
    currentSectionIndex: Int,
    onSectionChanged: (Int) -> Unit
) {
    when {
        uiState.isLoading -> HomeLoading()
        uiState.sectionList.isNotEmpty() -> HomeSuccess(
            modifier = modifier,
            currentSection = uiState.sectionList[currentSectionIndex],
            onSectionChanged = onSectionChanged,
            sectionList = uiState.sectionList,
            scrollState = scrollState
        )
        else -> HomeEmpty()
    }
}