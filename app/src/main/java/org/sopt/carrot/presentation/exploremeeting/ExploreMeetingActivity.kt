package org.sopt.carrot.presentation.exploremeeting

import android.content.Intent
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import org.sopt.carrot.R
import org.sopt.carrot.core.ui.base.BindingActivity
import org.sopt.carrot.databinding.ActivityExploreMeetingBinding
import org.sopt.carrot.presentation.joinmeeting.JoinMeetingActivity

class ExploreMeetingActivity :
    BindingActivity<ActivityExploreMeetingBinding>(R.layout.activity_explore_meeting) {

    private lateinit var exploreMeetingCollectionAdapter: ExploreMeetingCollectionAdapter
    private lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initAdapter()
        initAdapterSet()
        initTabLayoutItem()
        binding.btnSample.setOnClickListener {
            startActivity(Intent(this, JoinMeetingActivity::class.java))
        }
    }
    private fun initAdapter() {
        exploreMeetingCollectionAdapter = ExploreMeetingCollectionAdapter(supportFragmentManager, lifecycle)
        viewPager = binding.viewpagerMeeting
        viewPager.offscreenPageLimit = 6
        viewPager.adapter = exploreMeetingCollectionAdapter
    }

    private fun initTabLayoutItem() {
        val homeTabLayout = binding.tlNeighborMeeting
        val test = listOf("전체","운동","동네친구","스터디","가족육아","반려동물")
        TabLayoutMediator(homeTabLayout, viewPager) { tab, position ->
            tab.text =test[position]
        }.attach()
    }

    private fun initAdapterSet() {
        exploreMeetingCollectionAdapter.setData(listOf("전체","운동","동네친구","스터디","가족육아","반려동물"))
        exploreMeetingCollectionAdapter.notifyDataSetChanged()
    }
}