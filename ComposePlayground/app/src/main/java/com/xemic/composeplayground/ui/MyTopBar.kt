package com.xemic.composeplayground.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.xemic.composeplayground.common.theme.Gray400
import com.xemic.composeplayground.common.theme.Gray700
import com.xemic.composeplayground.common.theme.White

@Composable
fun MyTopBar(currentScreen: CommonNavigateItem) {
    Box {
        Text(
            text = currentScreen.appBarName,
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Gray400,
            modifier = Modifier
                .fillMaxWidth()
                .background(White)
                .padding(12.dp)
                .align(Alignment.Center),
        )

        if (currentScreen.bottomNavRoute == BottomNavigateItem.MyPage.route) {
            // 설정화면 버튼
            Icon(
                imageVector = Icons.Default.Settings,
                contentDescription = "",
                tint = Gray700,
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(end = 12.dp),
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun MyTopBarPreview() {
    MyTopBar(BottomNavigateItem.Home)
}
