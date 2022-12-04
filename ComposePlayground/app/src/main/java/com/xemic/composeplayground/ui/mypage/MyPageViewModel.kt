package com.xemic.composeplayground.ui.mypage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.xemic.composeplayground.common.model.Result
import com.xemic.composeplayground.data.model.SampleImage
import com.xemic.composeplayground.data.repository.UserRepository
import com.xemic.composeplayground.data.model.UserResponse
import com.xemic.composeplayground.data.repository.LoremRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MyPageViewModel @Inject constructor(
    private val repository: UserRepository,
    private val sampleRepository: LoremRepository
): ViewModel() {
    private val _sampleImageObserver = MutableLiveData<SampleImage>()
    val sampleImageObserver: LiveData<SampleImage> get() = _sampleImageObserver

    val userResponse: Result<UserResponse> = try {
        repository.getUserInfo().let { userResponse ->
            Result.Success(userResponse)
        }
    } catch (exception: Exception) {
        Result.Error(exception)
    }

    suspend fun fetchSampleImage() {
        val image = sampleRepository.getImageList(1)[3]
        _sampleImageObserver.postValue(image)
    }
}