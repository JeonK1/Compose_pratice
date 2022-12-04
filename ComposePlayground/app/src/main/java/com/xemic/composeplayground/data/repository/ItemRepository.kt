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
            Section("one", list.map { list[Random.nextInt(0, list.size-1)] }),
            Section("two", list.map { list[Random.nextInt(0, list.size-1)] }),
            Section("three", list.map { list[Random.nextInt(0, list.size-1)] }),
            Section("four", list.map { list[Random.nextInt(0, list.size-1)] }),
            Section("five", list.map { list[Random.nextInt(0, list.size-1)] }),
            Section("six", list.map { list[Random.nextInt(0, list.size-1)] }),
            Section("seven", list.map { list[Random.nextInt(0, list.size-1)] }),
            Section("eight", list.map { list[Random.nextInt(0, list.size-1)] }),
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