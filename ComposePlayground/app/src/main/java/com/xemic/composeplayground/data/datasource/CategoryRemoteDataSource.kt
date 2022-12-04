package com.xemic.composeplayground.data.datasource

import com.xemic.composeplayground.data.model.Category
import javax.inject.Inject

class CategoryRemoteDataSource @Inject constructor() {
    fun getCategoryListAll() = CategoryList
}
val CategoryList = listOf(
    Category(0, "(주)말하는감자", "https://play-lh.googleusercontent.com/xfFPCwwzxozXxEQ9vLe1Xf_CPwC6LuCnsLf5H2BcS2jq4O3dKyoSc5rjtdNgpXKx51GG=w240-h480-rw"),
    Category(1, "경호 전문업체", "https://kr.seaicons.com/wp-content/uploads/2015/08/guard-icon.png"),
    Category(2, "진실된 식료품", "https://cdn-icons-png.flaticon.com/512/3731/3731113.png"),
)