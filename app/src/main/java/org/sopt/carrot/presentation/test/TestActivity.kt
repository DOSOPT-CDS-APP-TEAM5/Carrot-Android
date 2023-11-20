package org.sopt.carrot.presentation.test
import android.os.Bundle
import androidx.activity.viewModels
import org.sopt.carrot.core.ui.base.BindingActivity
import org.sopt.carrot.R
import org.sopt.carrot.databinding.ActivityTestBinding
import org.sopt.carrot.presentation.ViewModelFactory

class TestActivity : BindingActivity<ActivityTestBinding>(R.layout.activity_test) {
    private val testViewModel: TestViewModel by viewModels { ViewModelFactory() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}