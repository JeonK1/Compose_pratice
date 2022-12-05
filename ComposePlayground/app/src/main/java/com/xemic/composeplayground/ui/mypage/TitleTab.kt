package com.xemic.composeplayground.ui.mypage

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.xemic.composeplayground.common.theme.Gray1000
import com.xemic.composeplayground.common.theme.Gray400
import com.xemic.composeplayground.common.theme.Gray900

@Composable
fun TitleTab(
    modifier: Modifier = Modifier,
    userName: String
) {
    Box(
        modifier
            .fillMaxWidth()
            .background(Gray1000)
            .border(1.dp, Gray900, RectangleShape)
            .padding(horizontal = 16.dp, vertical = 16.dp)
    ) {
        Column {
            Row {
                Text(
                    text = userName,
                    fontSize = 16.sp,
                    color = Gray400,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.alignByBaseline()
                )
                Text(
                    text = "님, 쇼핑하게 좋은 날이에요!",
                    fontSize = 14.sp,
                    color = Gray400,
                    modifier = Modifier.weight(1f).alignByBaseline()
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TitleTabPreview() {
    TitleTab(userName = "전계원")
}