package com.xemic.composeplayground.data.datasource

import com.xemic.composeplayground.data.model.UserInfo
import com.xemic.composeplayground.data.model.UserResponse
import javax.inject.Inject

class UserRemoteDataSource @Inject constructor() {
    fun getUserInfo() = UserResponse(false)
//    fun getUserInfo() = UserResponse(true, UserInfo("전계원"))
}