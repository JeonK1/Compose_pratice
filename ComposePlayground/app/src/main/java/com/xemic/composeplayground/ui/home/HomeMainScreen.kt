package com.xemic.composeplayground.ui.home

import HomeSuccess
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier

@Composable
fun HomeMainScreen(
    modifier: Modifier = Modifier,
    uiState: HomeViewModel.UiState,
    currentSectionIndex: Int,
    onSectionChanged: (Int) -> Unit,
) {
    when {
        uiState.isLoading -> HomeLoading()
        uiState.sectionList.isNotEmpty() -> HomeSuccess(
            modifier = modifier,
            currentSection = uiState.sectionList[currentSectionIndex],
            onSectionChanged = onSectionChanged,
            sectionList = uiState.sectionList
        )
        else -> HomeEmpty()
    }
}