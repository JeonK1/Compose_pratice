package com.xemic.composeplayground.ui.common

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.xemic.composeplayground.data.ItemInfo
import com.xemic.composeplayground.data.ItemInfoListSample

@Composable
fun GridList(
    modifier: Modifier = Modifier,
    data: List<ItemInfo>
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(data.size) { index ->
            GridListItem(modifier, data[index])
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun GridListItem(
    modifier: Modifier = Modifier,
    itemInfo: ItemInfo
) {
    Card(elevation = 8.dp) {
        Column {
            GlideImage(
                model = itemInfo.itemImageUrl,
                contentDescription = itemInfo.itemName,
                modifier = modifier.size(300.dp, 300.dp)
            )
            Text(
                text = itemInfo.brandName
            )
            Text(
                text = itemInfo.itemName
            )
            Text(
                text = "${itemInfo.price} 원"
            )
        }
    }
}