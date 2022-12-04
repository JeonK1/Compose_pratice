package com.xemic.composeplayground.ui.itemdetail

import androidx.lifecycle.ViewModel
import com.xemic.composeplayground.data.repository.ItemRepository
import com.xemic.composeplayground.common.model.Result
import com.xemic.composeplayground.data.model.ItemInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ItemDetailViewModel @Inject constructor(
    private val repository: ItemRepository
) : ViewModel() {
    fun getItemDetail(itemNo: Int): Result<ItemInfo> = try {
        repository.getItem(itemNo)?.let { itemInfo ->
            Result.Success(itemInfo)
        } ?: Result.Error(Exception("Data is not exists"))
    } catch (exception: Exception) {
        Result.Error(exception)
    }
}