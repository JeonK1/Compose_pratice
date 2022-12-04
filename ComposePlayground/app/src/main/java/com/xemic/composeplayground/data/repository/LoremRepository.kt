package com.xemic.composeplayground.data.repository

import com.xemic.composeplayground.data.datasource.LoremRemoteDataSource
import com.xemic.composeplayground.data.model.SampleImage
import javax.inject.Inject

class LoremRepository @Inject constructor(
    private val remoteDataSource: LoremRemoteDataSource
) {
    suspend fun getImageList(page: Int): List<SampleImage> = remoteDataSource.getImageList(page)
}