package com.xemic.composeplayground.data.model

data class UserResponse(
    val isLogin: Boolean,
    val result: UserInfo? = null,
)