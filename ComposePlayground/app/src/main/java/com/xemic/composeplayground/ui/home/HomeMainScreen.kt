package com.xemic.composeplayground.ui.home

import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.xemic.composeplayground.common.model.UiState
import com.xemic.composeplayground.ui.common.EmptyScreen
import com.xemic.composeplayground.ui.common.LoadingScreen

@Composable
fun HomeMainScreen(
    modifier: Modifier = Modifier,
    uiState: UiState<List<Section>>,
    scrollState: LazyGridState,
    currentSectionIndex: Int,
    onSectionChanged: (Int) -> Unit
) {
    when {
        uiState.isLoading -> LoadingScreen()
        uiState.data?.isNotEmpty() == true -> HomeSuccess(
            modifier = modifier,
            currentSection = uiState.data[currentSectionIndex],
            onSectionChanged = onSectionChanged,
            sectionList = uiState.data,
            scrollState = scrollState
        )
        else -> EmptyScreen(message = "아이템이 존재하지 않습니다")
    }
}