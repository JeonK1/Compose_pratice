package com.xemic.composeplayground.ui.common

import android.content.Intent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.xemic.composeplayground.data.model.ItemInfo
import com.xemic.composeplayground.ui.itemdetail.ItemDetailActivity

@Composable
fun GridList(
    modifier: Modifier = Modifier,
    data: List<ItemInfo>,
    scrollState: LazyGridState = LazyGridState()
) {
    val context = LocalContext.current
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        state = scrollState
    ) {
        items(data.size) { index ->
            GridListItem(
                modifier = modifier,
                itemInfo = data[index],
                onClickItem = { itemInfo ->
                    Intent(context, ItemDetailActivity::class.java).apply {
                        putExtra(ItemDetailActivity.ITEM_NO, itemInfo.itemNo)
                    }.let {
                        context.startActivity(it)
                    }
                }
            )
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun GridListItem(
    modifier: Modifier = Modifier,
    itemInfo: ItemInfo,
    onClickItem: (ItemInfo) -> Unit
) {
    Card(
        elevation = 8.dp,
        modifier = modifier.clickable(onClick = {
            onClickItem(itemInfo)
        })
    ) {
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