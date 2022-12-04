package com.xemic.composeplayground.data

import javax.inject.Inject

class UserRemoteDataSource @Inject constructor() {
//    fun getUserInfo() = UserResponse(false)
    fun getUserInfo() = UserResponse(true, UserInfo("xemic"))
}