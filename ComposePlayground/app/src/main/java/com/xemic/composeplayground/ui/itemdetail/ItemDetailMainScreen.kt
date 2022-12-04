package com.xemic.composeplayground.ui.itemdetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.SubcomposeAsyncImage
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

@Composable
fun ItemDetailSuccess(
    modifier: Modifier = Modifier,
    itemInfo: ItemInfo
) {
    Column {
        SubcomposeAsyncImage(
            model = itemInfo.itemImageUrl,
            contentDescription = itemInfo.itemName,
            modifier = modifier.size(300.dp, 300.dp)
        )
        Text(
            text = itemInfo.categoryInfo.categoryName
        )
        Text(
            text = itemInfo.itemName
        )
        Text(
            text = "${itemInfo.price} 원"
        )
    }
}

