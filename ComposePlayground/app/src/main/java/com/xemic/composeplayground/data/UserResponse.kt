package com.xemic.composeplayground.data

data class UserResponse(
    val isLogin: Boolean,
    val result: UserInfo? = null,
)