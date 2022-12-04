package com.xemic.composeplayground.data.repository

import com.xemic.composeplayground.data.datasource.ItemRemoteDataSource
import com.xemic.composeplayground.ui.home.Section
import javax.inject.Inject
import kotlin.random.Random

class ItemRepository @Inject constructor(
    private val remoteDataSource: ItemRemoteDataSource
) {
    fun getSectionListAll() = getItemListAll().let { list ->
        listOf(
            Section("추천상품", list.map { list[Random.nextInt(0, list.size-1)] }),
            Section("인테리어", list.map { list[Random.nextInt(0, list.size-1)] }),
            Section("식료품", list.map { list[Random.nextInt(0, list.size-1)] }),
            Section("가구", list.map { list[Random.nextInt(0, list.size-1)] }),
            Section("가전제품", list.map { list[Random.nextInt(0, list.size-1)] }),
            Section("선물하기", list.map { list[Random.nextInt(0, list.size-1)] }),
            Section("지마켓해커톤", list.map { list[Random.nextInt(0, list.size-1)] }),
            Section("마지막섹션", list.map { list[Random.nextInt(0, list.size-1)] }),
        )
    }

    fun getItemListAll() =
        remoteDataSource.getItemListAll()

    fun getItem(itemNo: Int) =
        getItemListAll().find { it.itemNo == itemNo }

    fun getItemListByCategoryNo(categoryNo: Int) =
        getItemListAll().filter { it.categoryInfo.categoryNo == categoryNo }

    fun getCategoryList() =
        getItemListAll().map { it.categoryInfo }.toSet().toList()
}