package com.xemic.composeplayground.data.repository

import com.xemic.composeplayground.data.datasource.UserRemoteDataSource
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val remoteDataSource: UserRemoteDataSource
) {
    fun getUserInfo() = remoteDataSource.getUserInfo()
}