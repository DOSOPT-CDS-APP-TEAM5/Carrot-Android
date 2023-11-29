package org.sopt.carrot.presentation.neighborhoodlife

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.sopt.carrot.data.repo.NeighborhoodLifeRepository

class NeighborhoodLifeViewModelProvider(
    private val neighborhoodLifeRepository: NeighborhoodLifeRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(NeighborhoodLifeRepository::class.java)
            .newInstance(neighborhoodLifeRepository)
    }
}