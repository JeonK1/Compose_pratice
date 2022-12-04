package com.xemic.composeplayground.ui.itemlist

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.xemic.composeplayground.common.model.Result
import com.xemic.composeplayground.common.model.UiState
import com.xemic.composeplayground.data.model.ItemInfo
import com.xemic.composeplayground.ui.common.EmptyScreen
import com.xemic.composeplayground.ui.common.LoadingScreen

@Composable
fun ItemListScreen(
    modifier: Modifier = Modifier,
    categoryNo: Int,
    viewModel: ItemListViewModel = hiltViewModel()
) {
    val uiState by produceState(initialValue = UiState<List<ItemInfo>>(isLoading = true)) {
        val result = viewModel.getItemListByCategoryNo(categoryNo)
        value = if(result is Result.Success) {
            UiState(data = result.data)
        } else {
            UiState(isError = true)
        }
    }

    when {
        uiState.isLoading -> LoadingScreen()
        uiState.data?.isNotEmpty() == true -> uiState.data?.let { itemList ->
            ItemListSuccess(
                modifier = modifier,
                data = itemList
            )
        } ?: EmptyScreen(message = "아이템이 존재하지 않습니다")
        else -> EmptyScreen(message = "아이템이 존재하지 않습니다")
    }
}