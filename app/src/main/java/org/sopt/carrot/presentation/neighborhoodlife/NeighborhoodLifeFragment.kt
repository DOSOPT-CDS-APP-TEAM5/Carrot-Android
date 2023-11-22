package org.sopt.carrot.presentation.neighborhoodlife

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import org.sopt.carrot.R
import org.sopt.carrot.core.ui.base.BindingFragment
import org.sopt.carrot.databinding.FragmentNeighborhoodLifeBinding
import org.sopt.carrot.presentation.neighborhoodlife.adapter.CarouselTagAdapter
import org.sopt.carrot.presentation.neighborhoodlife.adapter.CarouselTextAdapter
import org.sopt.carrot.presentation.neighborhoodlife.dummy.carouselTagList
import org.sopt.carrot.presentation.neighborhoodlife.dummy.carouselTextList

class NeighborhoodLifeFragment :
    BindingFragment<FragmentNeighborhoodLifeBinding>(R.layout.fragment_neighborhood_life) {
    private lateinit var carouselTextAdapter: CarouselTextAdapter
    private lateinit var carouselTagAdapter: CarouselTagAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        carouselTextAdapter = CarouselTextAdapter()
        binding.rcvMeeting.adapter = carouselTextAdapter
//        binding.rcvMeeting.layoutManager = LinearLayoutManager(requireContext())
        carouselTextAdapter.submitList(carouselTextList)

        carouselTagAdapter = CarouselTagAdapter()
        binding.rcvTopic.adapter = carouselTagAdapter
        carouselTagAdapter.submitList(carouselTagList)
    }

    fun newInstance(): Fragment = NeighborhoodLifeFragment()
}