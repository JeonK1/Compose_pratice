package com.xemic.composeplayground.ui.mypage

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.xemic.composeplayground.common.theme.Gray1000
import com.xemic.composeplayground.common.theme.Gray400
import com.xemic.composeplayground.common.theme.Gray700

@Composable
fun SelectableTab(
    modifier: Modifier = Modifier,
    text: String,
    isLast: Boolean = false,
    onClick: () -> Unit = { }
) {
    Box(
        modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(start = 16.dp, end = 16.dp, top = 13.dp)
    ) {
        Column {
            Row {
                Text(
                    text = text,
                    fontSize = 16.sp,
                    color = Gray400,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(1f)
                )
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = "",
                    tint = Gray700
                )
            }
            if (!isLast){
                Divider(
                    color = Gray1000,
                    thickness = 1.dp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SelectableTabPreview() {
    SelectableTab(
        text = "내 주문 현황",
        onClick = { }
    )
}