package com.xemic.composeplayground.ui.itemdetail

import android.app.Activity
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import com.xemic.composeplayground.common.theme.*
import com.xemic.composeplayground.data.model.ItemInfo
import com.xemic.composeplayground.ui.common.MyPageFooter
import com.xemic.composeplayground.ui.common.SubcomposeAsyncImageGradient

@Composable
fun ItemDetailSuccess(
    modifier: Modifier = Modifier,
    itemInfo: ItemInfo
) {
    val activity = (LocalContext.current as Activity)
    val scrollState = rememberScrollState()
    Column(
        modifier = modifier
            .verticalScroll(scrollState)
    ) {
        ItemDetailTopBar(
            onClickBackBtn = { activity.finish() }
        )
        SubcomposeAsyncImageGradient(
            model = itemInfo.itemImageUrl,
            contentDescription = itemInfo.itemName,
            contentScale = ContentScale.Crop,
            brush = Brush.verticalGradient(listOf(Transparent, BlackOp50)),
            modifier = modifier
                .fillMaxWidth()
                .aspectRatio(1f)
        )
        ItemInfoWidget(
            itemInfo = itemInfo,
            modifier = modifier.padding(16.dp)
        )
        Divider(
            thickness = 8.dp,
            color = Gray1000
        )
        SubcomposeAsyncImage(
            model = "https://www.bjb2b.co.kr/shopping/data/20161108_15.jpg",
            contentDescription = "상품설명",
            contentScale = ContentScale.FillWidth,
            modifier = modifier
                .fillMaxWidth()
                .heightIn(800.dp)
        )
        MyPageFooter(
            address = "서울특별시 강남구 152 테헤란로 34층",
            sellerNo = "117-12-40023",
            sellerPhoneNumber = "02-468-0246"
        )
    }
}