package com.xemic.composeplayground.data

import javax.inject.Inject

class UserRepository @Inject constructor(
    private val remoteDataSource: UserRemoteDataSource
) {
    fun getUserInfo() =
        remoteDataSource.getUserInfo()

}