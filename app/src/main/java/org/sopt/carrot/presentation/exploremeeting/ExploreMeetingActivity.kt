package org.sopt.carrot.presentation.exploremeeting

import android.content.Intent
import android.graphics.Paint
import android.os.Bundle
import androidx.activity.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import org.sopt.carrot.R
import org.sopt.carrot.core.ui.base.BindingActivity
import org.sopt.carrot.databinding.ActivityExploreMeetingBinding
import org.sopt.carrot.presentation.ViewModelFactory
import org.sopt.carrot.presentation.exploremeeting.adapter.HighlightAdapter
import org.sopt.carrot.presentation.exploremeeting.adapter.NewMeetingAdapter
import org.sopt.carrot.presentation.profile.ProfileActivity

class ExploreMeetingActivity :
    BindingActivity<ActivityExploreMeetingBinding>(R.layout.activity_explore_meeting) {

    private lateinit var exploreMeetingCollectionAdapter: ExploreMeetingCollectionAdapter
    private lateinit var viewPager: ViewPager2
    private lateinit var newMeetingAdapter: NewMeetingAdapter
    private lateinit var highlightAdapter: HighlightAdapter

    private val viewModel: ExploreMeetingViewModel by viewModels { ViewModelFactory(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initView()
        initTabAdapter()
        initTabAdapterSet()
        initTabLayoutItem()
        initMockAdapter()
        setOnClickProfile()
    }

    private fun initView() {
        binding.tvLongVillage.paintFlags = Paint.UNDERLINE_TEXT_FLAG
    }

    private fun initTabAdapter() {
        exploreMeetingCollectionAdapter =
            ExploreMeetingCollectionAdapter(supportFragmentManager, lifecycle)
        viewPager = binding.viewpagerMeeting
        viewPager.offscreenPageLimit = 6
        viewPager.adapter = exploreMeetingCollectionAdapter
    }

    private fun initTabLayoutItem() {
        val homeTabLayout = binding.tlNeighborMeeting
        val test = listOf("전체", "운동", "동네친구", "스터디", "가족육아", "반려동물")
        TabLayoutMediator(homeTabLayout, viewPager) { tab, position ->
            tab.text = test[position]
        }.attach()
    }

    private fun initTabAdapterSet() {
        exploreMeetingCollectionAdapter.setData(listOf("전체", "운동", "동네친구", "스터디", "가족육아", "반려동물"))
        exploreMeetingCollectionAdapter.notifyDataSetChanged()
    }

    private fun initMockAdapter() {
        newMeetingAdapter = NewMeetingAdapter()
        highlightAdapter = HighlightAdapter()
        binding.rvNewMeetingList.adapter = newMeetingAdapter
        binding.rvMeetingHighlight.adapter = highlightAdapter
        newMeetingAdapter.submitList(viewModel.newMeetingMockList)
        highlightAdapter.submitList(viewModel.meetingHighlightMockList)
    }

    private fun setOnClickProfile() {
        binding.ivProfile.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }
    }

}