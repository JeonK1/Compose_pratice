package com.xemic.composeplayground.ui.category

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.xemic.composeplayground.common.model.Result
import com.xemic.composeplayground.common.model.UiState
import com.xemic.composeplayground.data.model.Category
import com.xemic.composeplayground.ui.common.EmptyScreen
import com.xemic.composeplayground.ui.common.LoadingScreen

@Composable
fun CategoryMainScreen(
    onCategoryClicked: (Int) -> Unit,
    viewModel: CategoryViewModel = hiltViewModel()
) {
    val uiState by produceState(initialValue = UiState<List<Category>>(isLoading = true)) {
        val result = viewModel.categoryList
        value = if(result is Result.Success) {
            UiState(data = result.data)
        } else {
            UiState(isError = true)
        }
    }

    when {
        uiState.isLoading -> LoadingScreen()
        uiState.data?.isNotEmpty() == true -> CategorySuccess(
            categoryList = uiState.data ?: listOf(),
            onItemClick = { categoryNo -> onCategoryClicked(categoryNo) }
        )
        else -> EmptyScreen(message = "카테고리가 존재하지 않습니다.")
    }
}

@Preview(showBackground = true)
@Composable
fun CategoryScreenPreview() {
    CategoryMainScreen(onCategoryClicked = { })
}