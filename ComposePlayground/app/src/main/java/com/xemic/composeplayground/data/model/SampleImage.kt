package com.xemic.composeplayground.data.model

import com.google.gson.annotations.SerializedName

data class SampleImage(
    @SerializedName("id") val id: String,                       // 이미지 고유 id
    @SerializedName("author") val author: String,               // 이미지 주인
    @SerializedName("width") val width: Int,                    // original image width
    @SerializedName("height") val height: Int,                  // original image height
    @SerializedName("url") val imageOriginalUrl: String,        // original image url
    @SerializedName("download_url") val imageUrl: String,       // download image url
)
