package org.sopt.carrot.presentation.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.sopt.carrot.data.model.BaseResponse
import org.sopt.carrot.data.repo.ProfileRepository

class ProfileViewModel(
    private val profileRepository: ProfileRepository
): ViewModel() {
    private val _responseSuccess = MutableLiveData<BaseResponse<String>>()
    val responseSuccess: LiveData<BaseResponse<String>> = _responseSuccess

    fun postProfile(id: Int = 1, nickname: String, information: String, throwMessage: (String) -> Unit) {
        viewModelScope.launch {
            runCatching {
                profileRepository.postProfile(id, nickname, information)
            }.onSuccess {
                _responseSuccess.value = it
            }.onFailure {
                throwMessage(it.message.toString())
            }
        }
    }
}