package org.sopt.carrot.presentation.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.sopt.carrot.data.repo.ProfileRepository

class ProfileViewModelProvider(
    private val profileRepository: ProfileRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(ProfileRepository::class.java)
            .newInstance(profileRepository)
    }
}