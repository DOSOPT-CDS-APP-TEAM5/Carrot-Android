package org.sopt.carrot.presentation.neighborhoodlife

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import org.sopt.carrot.R
import org.sopt.carrot.core.ui.base.BindingFragment
import org.sopt.carrot.databinding.FragmentNeighborhoodLifeBinding

class NeighborhoodLifeFragment :
    BindingFragment<FragmentNeighborhoodLifeBinding>(R.layout.fragment_neighborhood_life) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    fun newInstance(): Fragment = NeighborhoodLifeFragment()
}