package com.xemic.composeplayground.ui.home

import androidx.lifecycle.ViewModel
import com.xemic.composeplayground.data.repository.ItemRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import com.xemic.composeplayground.common.model.Result

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: ItemRepository
) : ViewModel() {
    val sectionList: Result<List<Section>>
        get() = try {
            val sections = repository.getSectionListAll()
            Result.Success(sections)
        } catch (exception: Exception) {
            Result.Error(exception)
        }
}