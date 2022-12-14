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
import com.xemic.composeplayground.ui.common.MyPageFooter

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
        } ?: EmptyScreen(message = "????????? ????????? ???????????? ????????????")
        else -> EmptyScreen(message = "????????? ????????? ???????????? ????????????")
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
                SelectableTab(text = "??? ?????? ??????")
                SelectableTab(text = "??? ??????")
                SelectableTab(text = "?????? ??????")
                SelectableTab(text = "????????????")

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
            address = "??????????????? ????????? 152 ???????????? 34???",
            sellerNo = "117-12-40023",
            sellerPhoneNumber = "02-468-0246"
        )
    }
}