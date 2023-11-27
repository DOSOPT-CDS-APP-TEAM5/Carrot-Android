package org.sopt.carrot.presentation.neighborhoodlife

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.sopt.carrot.data.model.neighborhoodlife.LivesDataResponse
import org.sopt.carrot.data.repo.NeighborhoodLifeRepository

class NeighborhoodViewModel(
    private val neighborhoodLifeRepository: NeighborhoodLifeRepository
): ViewModel() {
    private val _livesList = MutableLiveData<List<LivesDataResponse>>()
    val livesList: LiveData<List<LivesDataResponse>> get() = _livesList

    fun getLives(category: String) {
        viewModelScope.launch {
            kotlin.runCatching {
                neighborhoodLifeRepository.getLives(category)
            }.onSuccess {
                _livesList.value = it
            }.onFailure {
                _livesList.value = emptyList()
            }
        }
    }
}