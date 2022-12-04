package com.xemic.composeplayground.ui.itemlist

import androidx.lifecycle.ViewModel
import com.xemic.composeplayground.common.model.Result
import com.xemic.composeplayground.data.model.ItemInfo
import com.xemic.composeplayground.data.repository.ItemRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ItemListViewModel @Inject constructor(
    private val repository: ItemRepository
): ViewModel() {
    fun getItemListByCategoryNo(categoryNo: Int): Result<List<ItemInfo>> =
        try {
            val categories = repository.getItemListByCategoryNo(categoryNo)
            Result.Success(categories)
        } catch (exception: Exception) {
            Result.Error(exception)
        }
}