package com.xemic.composeplayground.data.model

import com.xemic.composeplayground.ui.CommonNavigateItem

data class ItemInfo(
    val itemNo: Int,
    val categoryInfo: Category,
    val itemName: String,
    val itemImageUrl: String,
    val price: Int
)

