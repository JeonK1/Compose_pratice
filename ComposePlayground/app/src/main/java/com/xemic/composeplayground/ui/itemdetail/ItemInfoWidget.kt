package com.xemic.composeplayground.ui.itemdetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.xemic.composeplayground.common.ext.toStringDecimalFormat
import com.xemic.composeplayground.common.theme.Black
import com.xemic.composeplayground.common.theme.Gray700
import com.xemic.composeplayground.data.model.ItemInfo

@Composable
fun ItemInfoWidget(
    modifier: Modifier = Modifier,
    itemInfo: ItemInfo
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Image(
            imageVector = Icons.Default.Share,
            contentDescription = "공유하기",
            modifier = Modifier.align(Alignment.TopEnd)
        )
        Column {
            Text(
                text = itemInfo.categoryInfo.categoryName,
                color = Gray700,
                fontSize = 12.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = itemInfo.itemName,
                color = Black,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Row(
                modifier = Modifier.padding(bottom = 8.dp)
            ) {
                Text(
                    text = itemInfo.price.toStringDecimalFormat(),
                    color = Black,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.alignByBaseline()
                )
                Text(
                    text = " 원",
                    color = Black,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.alignByBaseline()
                )
            }
        }
    }
}