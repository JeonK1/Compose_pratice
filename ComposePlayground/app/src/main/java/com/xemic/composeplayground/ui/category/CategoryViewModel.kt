package com.xemic.composeplayground.ui.category

import androidx.lifecycle.ViewModel
import com.xemic.composeplayground.data.repository.ItemRepository
import com.xemic.composeplayground.common.model.Result
import com.xemic.composeplayground.data.model.Category
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(
    private val repository: ItemRepository
): ViewModel() {
    val categoryList: Result<List<Category>>
        get() = try {
            val categories = repository.getCategoryList()
            Result.Success(categories)
        } catch (exception: Exception) {
            Result.Error(exception)
        }
}