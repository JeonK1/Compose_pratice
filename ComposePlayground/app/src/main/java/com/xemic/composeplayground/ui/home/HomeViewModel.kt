package com.xemic.composeplayground.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import com.xemic.composeplayground.data.ItemInfo
import com.xemic.composeplayground.data.ItemRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val itemRepository: ItemRepository
) : ViewModel() {
    val sectionList: Result<List<Section>>
        get() = try {
            Log.e("Tset", "Heelo")
            val sections = itemRepository.getSectionListAll()
            Result.Success(sections)
        } catch (exception: Exception) {
            Result.Error(exception)
        }

    data class UiState(
        val isLoading: Boolean = false,
        val isError: Boolean = false,
        val sectionList: List<Section> = listOf()
    )

    sealed class Result<out R> {
        data class Success<out T>(val data: T) : Result<T>()
        data class Error(val exception: Exception) : Result<Nothing>()
    }
}