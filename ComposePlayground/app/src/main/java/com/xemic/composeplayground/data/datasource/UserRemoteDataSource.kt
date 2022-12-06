package com.xemic.composeplayground.data.datasource

import com.xemic.composeplayground.data.model.UserInfo
import javax.inject.Inject

class UserRemoteDataSource @Inject constructor() {
    fun getUserInfo() = UserInfo("제믹")
}