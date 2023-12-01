package org.sopt.carrot.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.sopt.carrot.data.api.RetrofitServicePool
import org.sopt.carrot.data.datasource.remote.ExploreMeetingDataSource
import org.sopt.carrot.data.repo.ExploreMeetingRepository
import org.sopt.carrot.presentation.exploremeeting.ExploreMeetingViewModel

class ViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ExploreMeetingViewModel::class.java)) {
            return ExploreMeetingViewModel(
                ExploreMeetingRepository(
                    ExploreMeetingDataSource(
                        RetrofitServicePool.carrotService
                    )
                )
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}