package com.xemic.composeplayground.ui.common

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import com.xemic.composeplayground.common.theme.Black
import com.xemic.composeplayground.common.theme.Blue500
import com.xemic.composeplayground.common.theme.Gray1000
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
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(
            top = 16.dp,
            bottom = 16.dp
        ),
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

@Composable
fun GridListItem(
    modifier: Modifier = Modifier,
    itemInfo: ItemInfo,
    onClickItem: (ItemInfo) -> Unit
) {
    Card(
        elevation = 0.dp,
        modifier = modifier.clickable(onClick = {
            onClickItem(itemInfo)
        })
    ) {
        Box {
            Column(
                modifier = modifier.align(Alignment.Center)
            ) {
                SubcomposeAsyncImage(
                    model = itemInfo.itemImageUrl,
                    contentDescription = itemInfo.itemName,
                    modifier = modifier
                        .fillMaxWidth()
                        .aspectRatio(1f)
                        .background(Gray1000)
                        .clip(RoundedCornerShape(10.dp)),
                )
                Text(
                    modifier = modifier.padding(top = 5.dp),
                    text = itemInfo.categoryInfo.categoryName,
                    color = Blue500,
                    fontSize = 10.sp
                )
                Text(
                    text = itemInfo.itemName,
                    fontSize = 14.sp,
                    color = Black
                )
                Row {
                    Text(
                        text = "${itemInfo.price}",
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 16.sp,
                        color = Black,
                        modifier = modifier.alignByBaseline()
                    )
                    Text(
                        text = "원",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        color = Black,
                        modifier = modifier.alignByBaseline()
                    )
                }
            }
        }
    }
}