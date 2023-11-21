package org.sopt.carrot.presentation

import android.os.Bundle
import org.sopt.carrot.R
import org.sopt.carrot.core.ui.base.BindingActivity
import org.sopt.carrot.databinding.ActivityMainBinding
import org.sopt.carrot.presentation.neighborhoodlife.NeighborhoodLifeFragment

class MainActivity : BindingActivity<ActivityMainBinding>(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.bnvMain.selectedItemId = R.id.menu_life

        initFragment()
    }

    private fun initFragment() {
        val currentFragment = supportFragmentManager.findFragmentById(R.id.fcv_main)
        if (currentFragment == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fcv_main, NeighborhoodLifeFragment().newInstance())
                .commit()
        }
    }
}