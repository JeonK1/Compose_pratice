package com.xemic.composeplayground.data

import com.xemic.composeplayground.ui.home.Section
import javax.inject.Inject
import kotlin.random.Random

class ItemRepository @Inject constructor(
    private val remoteDataSource: ItemRemoteDataSource
) {
    fun getSectionListAll() = listOf(
        Section("one", ItemInfoListSample.map { itemInfo -> ItemInfoListSample[Random.nextInt(0, ItemInfoListSample.size-1)] }),
        Section("two", ItemInfoListSample.map { itemInfo -> ItemInfoListSample[Random.nextInt(0, ItemInfoListSample.size-1)] }),
        Section("three", ItemInfoListSample.map { itemInfo -> ItemInfoListSample[Random.nextInt(0, ItemInfoListSample.size-1)] }),
        Section("four", ItemInfoListSample.map { itemInfo -> ItemInfoListSample[Random.nextInt(0, ItemInfoListSample.size-1)] }),
        Section("five", ItemInfoListSample.map { itemInfo -> ItemInfoListSample[Random.nextInt(0, ItemInfoListSample.size-1)] }),
        Section("six", ItemInfoListSample.map { itemInfo -> ItemInfoListSample[Random.nextInt(0, ItemInfoListSample.size-1)] }),
        Section("seven", ItemInfoListSample.map { itemInfo -> ItemInfoListSample[Random.nextInt(0, ItemInfoListSample.size-1)] }),
        Section("eight", ItemInfoListSample.map { itemInfo -> ItemInfoListSample[Random.nextInt(0, ItemInfoListSample.size-1)] }),
    )

    fun getItemListAll() =
        remoteDataSource.ItemInfoListSample

    fun getItem(itemNo: Int) =
        remoteDataSource.ItemInfoListSample.find { it.itemNo == itemNo }

    fun getItemListByCategory(categoryName: String) =
        remoteDataSource.ItemInfoListSample.find { it.brandName == categoryName }

    fun getCategoryList() =
        ItemInfoListSample.map { it.brandName }.toSet().toList()
}