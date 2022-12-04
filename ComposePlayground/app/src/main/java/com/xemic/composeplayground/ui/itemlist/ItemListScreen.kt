package com.xemic.composeplayground.ui.itemlist

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.xemic.composeplayground.data.ItemInfo
import com.xemic.composeplayground.data.ItemInfoListSample
import com.xemic.composeplayground.ui.common.GridList

@Composable
fun ItemListScreen(
    modifier: Modifier = Modifier,
    data: List<ItemInfo>,
) {
    GridList(
        modifier = modifier,
        data = data
    )
}
@Preview(showBackground = true)
@Composable
fun MyPageScreenPreview() {
    ItemListScreen(data = ItemInfoListSample)
}
