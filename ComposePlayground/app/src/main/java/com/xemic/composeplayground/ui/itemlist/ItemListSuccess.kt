package com.xemic.composeplayground.ui.itemlist

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.xemic.composeplayground.data.model.ItemInfo
import com.xemic.composeplayground.ui.common.GridList

@Composable
fun ItemListSuccess(
    modifier: Modifier = Modifier,
    data: List<ItemInfo>,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp)
    ) {
        GridList(
            modifier = modifier,
            data = data
        )
    }
}