package com.xemic.composeplayground.ui.mypage

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import com.xemic.composeplayground.ui.CommonNavigateItem

@Composable
fun MyPageScreen(
    modifier: Modifier = Modifier,
    navigateToLoginScreen: () -> Unit
) {
    Column(
        modifier = modifier,
    ) {
        Box(modifier = modifier.weight(1f)) {
            Column {
                Text("<내이름> 고객님 안녕하세요")

                // 이건 Clickable Bar 형태
                Text("내 주문 현황")
                Text("구매했던 상품")
                Text("내 쿠폰")
                Text("문의 내역")
            }
        }
        MyPageFooter()
    }
}

@Composable
fun MyPageFooter() {
    Column {
        Text("나의 사업자 번호")
        Text("사무실 주소")
        Text("고객 문의는 이쪽으로")
    }
}

@Preview(showBackground = true)
@Composable
fun MyPageScreenPreview() {
    MyPageScreen(
        navigateToLoginScreen = { }
    )
}
