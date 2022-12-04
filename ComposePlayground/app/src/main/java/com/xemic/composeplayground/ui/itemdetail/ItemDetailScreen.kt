package com.xemic.composeplayground.ui.itemdetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.xemic.composeplayground.data.ItemInfo

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ItemDetailScreen(
    modifier: Modifier = Modifier,
    itemInfo: ItemInfo
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
