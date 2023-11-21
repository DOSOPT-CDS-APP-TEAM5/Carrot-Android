package org.sopt.carrot.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.sopt.carrot.data.datasource.TestDataSource
import org.sopt.carrot.data.repo.TestRepoImpl
//import org.sopt.carrot.presentation.test.TestViewModel

class ViewModelFactory : ViewModelProvider.Factory {
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(TestViewModel::class.java)) {
//            return TestViewModel(TestRepoImpl(TestDataSource())) as T
//        }
//        throw IllegalArgumentException("Unknown ViewModel Class")
//    }
}