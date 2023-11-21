package org.sopt.carrot.presentation

import android.os.Bundle
import org.sopt.carrot.R
import org.sopt.carrot.core.ui.base.BindingActivity
import org.sopt.carrot.databinding.ActivityMainBinding

class MainActivity : BindingActivity<ActivityMainBinding>(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.bnvMain.selectedItemId = R.id.menu_life
    }
}