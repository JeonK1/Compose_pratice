package com.xemic.composeplayground.data.repository

import com.xemic.composeplayground.data.datasource.CategoryRemoteDataSource
import com.xemic.composeplayground.data.datasource.ItemRemoteDataSource
import com.xemic.composeplayground.ui.home.Section
import javax.inject.Inject
import kotlin.random.Random

class CategoryRepository @Inject constructor(
    private val remoteDataSource: CategoryRemoteDataSource
) {
    fun getCategoryList() =
        remoteDataSource.getCategoryListAll()
}