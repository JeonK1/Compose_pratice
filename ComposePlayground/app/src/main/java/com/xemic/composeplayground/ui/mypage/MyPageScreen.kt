package com.xemic.composeplayground.ui.mypage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.xemic.composeplayground.common.model.UiState
import com.xemic.composeplayground.common.model.Result
import com.xemic.composeplayground.common.theme.Gray700
import com.xemic.composeplayground.common.theme.Gray900
import com.xemic.composeplayground.data.model.UserInfo
import com.xemic.composeplayground.data.model.UserResponse
import com.xemic.composeplayground.ui.common.EmptyScreen
import com.xemic.composeplayground.ui.common.LoadingScreen
import com.xemic.composeplayground.R
import com.xemic.composeplayground.common.theme.Gray1000

@Composable
fun MyPageScreen(
    modifier: Modifier = Modifier,
    navigateToLoginScreen: () -> Unit,
    viewModel: MyPageViewModel = hiltViewModel()
) {
    val uiState by produceState(initialValue = UiState<UserResponse>(isLoading = true)) {
        val result = viewModel.userResponse
        value = if (result is Result.Success) {
            UiState(data = result.data)
        } else {
            UiState(isError = true)
        }
    }

    when {
        uiState.isLoading -> LoadingScreen()
        uiState.data?.isLogin == false -> {
            navigateToLoginScreen()
        }
        uiState.data?.isLogin == true -> uiState.data?.result?.let { userInfo ->
            MyPageSuccess(
                modifier = modifier,
                userInfo = userInfo,
                viewModel = viewModel
            )
        } ?: EmptyScreen(message = "사용자 정보가 존재하지 않습니다")
        else -> EmptyScreen(message = "사용자 정보가 존재하지 않습니다")
    }
}

@Composable
fun MyPageSuccess(
    modifier: Modifier = Modifier,
    userInfo: UserInfo,
    viewModel: MyPageViewModel,
) {
    // Todo : Sample Image by Retrofit
//    LaunchedEffect(true) {
//        viewModel.fetchSampleImage()
//    }
//
//    val sampleImage = viewModel.sampleImageObserver.observeAsState()

    Column(
        modifier = modifier,
    ) {
        Box(modifier = modifier.weight(1f)) {
            Column {
                TitleTab(userName = userInfo.userName)
                SelectableTab(text = "내 주문 현황")
                SelectableTab(text = "내 쿠폰")
                SelectableTab(text = "문의 내역")
                SelectableTab(text = "로그아웃")

                // Todo : Sample Image by Retrofit
//                sampleImage.value?.let { image ->
//                    SubcomposeAsyncImage(
//                        model = image.imageUrl,
//                        contentDescription = image.author,
//                        modifier = modifier.size(300.dp, 300.dp)
//                    )
//                }
            }
        }
        MyPageFooter(
            address = "서울특별시 강남구 152 테헤란로 34층",
            sellerNo = "117-12-40023",
            sellerPhoneNumber = "02-468-0246"
        )
    }
}

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
