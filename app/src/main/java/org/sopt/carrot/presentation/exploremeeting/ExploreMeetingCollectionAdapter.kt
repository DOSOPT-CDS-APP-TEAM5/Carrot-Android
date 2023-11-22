package org.sopt.carrot.presentation.exploremeeting

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class ExploreMeetingCollectionAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    private var dataSet: List<String> = emptyList()
    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun createFragment(position: Int): Fragment {
        return ScreenMeetingSlideFragment.newInstance(dataSet[position])
    }

    fun setData(newData: List<String>) {
        dataSet = newData
        notifyDataSetChanged()
    }
}