package com.xemic.composeplayground.ui.itemdetail

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
fun ItemDetailMainScreen(
    modifier: Modifier = Modifier,
    itemNo: Int,
    viewModel: ItemDetailViewModel = hiltViewModel()
) {
    val uiState by produceState(initialValue = UiState<ItemInfo>(isLoading = true)) {
        val result = viewModel.getItemDetail(itemNo)
        value = if(result is Result.Success) {
            UiState(data = result.data)
        } else {
            UiState(isError = true)
        }
    }

    when {
        uiState.isLoading -> LoadingScreen()
        uiState.data != null -> uiState.data?.let { itemInfo ->
            ItemDetailSuccess(
                modifier = modifier,
                itemInfo = itemInfo
            )
        } ?: EmptyScreen(message = "아이템 정보가 존재하지 않습니다")
        else -> EmptyScreen(message = "아이템 정보가 존재하지 않습니다")
    }
}
