package org.sopt.carrot.presentation.exploremeeting

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import org.sopt.carrot.R
import org.sopt.carrot.core.ui.base.BindingFragment
import org.sopt.carrot.databinding.ItemFragmentMeetingBinding
import org.sopt.carrot.presentation.exploremeeting.adapter.MeetingAdapter

class ScreenMeetingSlideFragment :
    BindingFragment<ItemFragmentMeetingBinding>(R.layout.item_fragment_meeting) {

    private lateinit var meetingAdapter: MeetingAdapter
    private val viewModel by viewModels<ExploreMeetingViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data = arguments?.getString("data")
        initAdapter()
    }

    private fun initAdapter() {
        meetingAdapter = MeetingAdapter()
        binding.rvMeetingList.adapter = meetingAdapter
        meetingAdapter.submitList(viewModel.meetingMockList)
    }

    companion object {
        @JvmStatic
        fun newInstance(data: String): ScreenMeetingSlideFragment {
            val fragment = ScreenMeetingSlideFragment()
            val args = Bundle()
            args.putString("data", data)
            fragment.arguments = args
            return fragment
        }
    }
}

