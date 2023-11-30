package org.sopt.carrot.presentation.neighborhoodlife

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import org.sopt.carrot.CarrotApp
import org.sopt.carrot.R
import org.sopt.carrot.core.ui.base.BindingFragment
import org.sopt.carrot.core.ui.fragment.snackBar
import org.sopt.carrot.databinding.FragmentNeighborhoodLifeBinding
import org.sopt.carrot.presentation.exploremeeting.ExploreMeetingActivity
import org.sopt.carrot.presentation.neighborhoodlife.adapter.CarouselTagAdapter
import org.sopt.carrot.presentation.neighborhoodlife.adapter.CarouselTextAdapter
import org.sopt.carrot.presentation.neighborhoodlife.adapter.NeighborhoodLifeAdapter
import org.sopt.carrot.presentation.neighborhoodlife.dummy.carouselTagList
import org.sopt.carrot.presentation.neighborhoodlife.dummy.carouselTextList
import org.sopt.carrot.presentation.profile.ProfileActivity

class NeighborhoodLifeFragment :
    BindingFragment<FragmentNeighborhoodLifeBinding>(R.layout.fragment_neighborhood_life) {
    private lateinit var neighborhoodViewModel: NeighborhoodViewModel

    private lateinit var neighborhoodLifeAdapter: NeighborhoodLifeAdapter
    private lateinit var carouselTextAdapter: CarouselTextAdapter
    private lateinit var carouselTagAdapter: CarouselTagAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initNeighborhoodLifeViewModel()
        initCarouselTextDummyAdapter()
        initCarouselTagDummyAdapter()
        initNeighborhoodLifeAdapter()
        initLives()
        setOnClickProfile()
        setOnExploreMeeting()
        observeData()
    }

    private fun initNeighborhoodLifeViewModel() {
        neighborhoodViewModel = NeighborhoodLifeViewModelProvider(
            CarrotApp.getNeighborhoodLifeRepositoryInstance()
        ).create(NeighborhoodViewModel::class.java)
    }

    private fun initCarouselTextDummyAdapter() {
        carouselTextAdapter = CarouselTextAdapter()
        binding.rcvMeeting.adapter = carouselTextAdapter
        carouselTextAdapter.submitList(carouselTextList)
    }

    private fun initCarouselTagDummyAdapter() {
        carouselTagAdapter = CarouselTagAdapter(::onClickTag)
        binding.rcvTopic.adapter = carouselTagAdapter
        carouselTagAdapter.submitList(carouselTagList)
    }

    private fun onClickTag(tag: String) {
        neighborhoodViewModel.getLives(tag)
    }

    private fun initNeighborhoodLifeAdapter() {
        neighborhoodLifeAdapter = NeighborhoodLifeAdapter()
        binding.rcvContents.adapter = neighborhoodLifeAdapter
        binding.rcvContents.addItemDecoration(DividerItemDecoration(requireContext(), VERTICAL))
    }

    private fun initLives() {
        neighborhoodViewModel.getLives()
    }

    private fun setOnClickProfile() {
        binding.ivProfile.setOnClickListener {
            startActivity(Intent(requireContext(), ProfileActivity::class.java))
        }
    }

    private fun setOnExploreMeeting() {
        binding.linearLayoutMoreExploreMeeting.setOnClickListener {
            startActivity(Intent(requireContext(), ExploreMeetingActivity::class.java))
        }
    }

    private fun observeData() {
        neighborhoodViewModel.livesList.observe(viewLifecycleOwner) {
            if (it.isEmpty()) {
                snackBar(binding.root) { getString(R.string.empty_list) }
                return@observe
            }
            neighborhoodLifeAdapter.submitList(it)
        }
    }

    fun newInstance(): Fragment = NeighborhoodLifeFragment()
}