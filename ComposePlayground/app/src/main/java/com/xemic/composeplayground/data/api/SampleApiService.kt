package com.xemic.composeplayground.data.api

import com.xemic.composeplayground.data.model.SampleImage
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SampleApiService {
    /***
     * Image Details
     * @param id : 이미지의 고유 id
     * ***/
    @GET("/id/{id}/info")
    suspend fun getImageInfo(
        @Path("id") id:String
    ): SampleImage

    /***
     * List Images
     * @param page : 가져올 이미지 리스트의 page
     * @param limit : 한 page 에 포함된 최대 개수
     * ***/
    @GET("/v2/list")
    suspend fun getImageList(
        @Query("page") page: Int,
        @Query("limit") limit: Int
    ): List<SampleImage>
}