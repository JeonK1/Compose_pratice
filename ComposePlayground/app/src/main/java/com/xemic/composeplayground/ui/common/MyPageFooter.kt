package com.xemic.composeplayground.ui.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.xemic.composeplayground.R
import com.xemic.composeplayground.common.theme.Gray1000
import com.xemic.composeplayground.common.theme.Gray700

@Composable
fun MyPageFooter(
    modifier: Modifier = Modifier,
    address: String,
    sellerNo: String,
    sellerPhoneNumber: String
) {
    Column(
        modifier = modifier
            .background(Gray1000)
            .padding(horizontal = 16.dp, vertical = 16.dp)
    ) {
        Text(
            text = "고객문의 : $sellerPhoneNumber",
            color = Gray700,
            fontSize = 11.sp
        )
        Text(
            text = "주소 : $address",
            color = Gray700,
            fontSize = 11.sp
        )
        Text(
            text = "사업자번호 : $sellerNo",
            color = Gray700,
            fontSize = 11.sp
        )
        Text(
            text = "Jasa Mall 은 통신판매중개자이며 통신판매의 당사자가 아닙니다. 따라서 Jasa Mall 은 상품 거래 정보 및 가격에 대하여 책임을 지지 않습니다.",
            color = Gray700,
            fontSize = 11.sp
        )
        Text(
            text = "Copyright Jasa Mall, All rights reserved",
            color = Gray700,
            fontSize = 11.sp
        )
        Image(
            painter = painterResource(R.drawable.allymarket_title),
            contentDescription = "",
            modifier = Modifier
                .padding(top = 10.dp)
                .size(width = 70.dp, height = 30.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MyPageFooterPreview() {
    MyPageFooter(
        address = "서울특별시 강남구 152 테헤란로 34층",
        sellerNo = "117-12-40023",
        sellerPhoneNumber = "02-468-0246"
    )
}
