package com.xemic.composeplayground.ui.itemlist

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.xemic.composeplayground.data.model.ItemInfo
import com.xemic.composeplayground.ui.common.GridList

@Composable
fun ItemListSuccess(
    modifier: Modifier = Modifier,
    data: List<ItemInfo>,
) {
    GridList(
        modifier = modifier,
        data = data
    )
}