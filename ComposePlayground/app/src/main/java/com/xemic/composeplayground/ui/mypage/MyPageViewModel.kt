package com.xemic.composeplayground.ui.mypage

import androidx.lifecycle.ViewModel
import com.xemic.composeplayground.common.model.Result
import com.xemic.composeplayground.data.UserRepository
import com.xemic.composeplayground.data.UserResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MyPageViewModel @Inject constructor(
    private val repository: UserRepository
): ViewModel() {
    val userResponse: Result<UserResponse> = try {
        repository.getUserInfo().let { userResponse ->
            Result.Success(userResponse)
        }
    } catch (exception: Exception) {
        Result.Error(exception)
    }
}