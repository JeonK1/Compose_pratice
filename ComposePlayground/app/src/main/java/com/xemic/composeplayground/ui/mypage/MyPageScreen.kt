package com.xemic.composeplayground.ui.mypage

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.xemic.composeplayground.common.model.UiState
import com.xemic.composeplayground.common.model.Result
import com.xemic.composeplayground.data.UserInfo
import com.xemic.composeplayground.data.UserResponse
import com.xemic.composeplayground.ui.common.EmptyScreen
import com.xemic.composeplayground.ui.common.LoadingScreen

@Composable
fun MyPageScreen(
    modifier: Modifier = Modifier,
    navigateToLoginScreen: () -> Unit,
    viewModel: MyPageViewModel = hiltViewModel()
) {
    val uiState by produceState(initialValue = UiState<UserResponse>(isLoading = true)) {
        val result = viewModel.userResponse
        value = if(result is Result.Success) {
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
                userInfo = userInfo
            )
        } ?: EmptyScreen(message = "사용자 정보가 존재하지 않습니다")
        else -> EmptyScreen(message = "사용자 정보가 존재하지 않습니다")
    }
}

@Composable
fun MyPageSuccess(
    modifier: Modifier = Modifier,
    userInfo: UserInfo
) {
    Column(
        modifier = modifier,
    ) {
        Box(modifier = modifier.weight(1f)) {
            Column {
                Text("${userInfo.userName} 고객님 안녕하세요")

                // 이건 Clickable Bar 형태
                Text("내 주문 현황")
                Text("구매했던 상품")
                Text("내 쿠폰")
                Text("문의 내역")
                Text("로그아웃")
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
