package com.xemic.composeplayground.ui.mypage

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.xemic.composeplayground.ui.common.MyPageFooter

@Composable
fun MyPageScreen(
    modifier: Modifier = Modifier,
    viewModel: MyPageViewModel = hiltViewModel()
) {
    MyPageSuccess(
        modifier = modifier,
        viewModel = viewModel
    )
}

@Composable
fun MyPageSuccess(
    modifier: Modifier = Modifier,
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
                TitleTab(userName = viewModel.getUserInfo().userName)
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