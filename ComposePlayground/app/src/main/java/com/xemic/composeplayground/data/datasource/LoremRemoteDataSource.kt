package com.xemic.composeplayground.data.datasource

import com.xemic.composeplayground.data.api.SampleApiService
import com.xemic.composeplayground.data.model.SampleImage
import javax.inject.Inject

class LoremRemoteDataSource @Inject constructor(
    private val apiService: SampleApiService
) {
    /*** image list 가져오기 ***/
    suspend fun getImageList(page: Int): List<SampleImage> = apiService.getImageList(page, 10)
}