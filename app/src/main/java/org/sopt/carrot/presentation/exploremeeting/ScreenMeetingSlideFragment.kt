package org.sopt.carrot.presentation.exploremeeting

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.sopt.carrot.R
import org.sopt.carrot.core.ui.base.BindingFragment
import org.sopt.carrot.core.ui.view.UiState
import org.sopt.carrot.databinding.ItemFragmentMeetingBinding
import org.sopt.carrot.presentation.ViewModelFactory
import org.sopt.carrot.presentation.exploremeeting.adapter.MeetingAdapter
import org.sopt.carrot.presentation.joinmeeting.JoinMeetingActivity

class ScreenMeetingSlideFragment :
    BindingFragment<ItemFragmentMeetingBinding>(R.layout.item_fragment_meeting) {

    private lateinit var meetingAdapter: MeetingAdapter
    private val viewModel: ExploreMeetingViewModel by viewModels { ViewModelFactory(requireContext()) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data = arguments?.getString("data")
        when (data) {
            "전체" ->
                viewModel.getClubs()

            "가족육아" ->
                viewModel.getClubs()
            // 가족육아는 데이터가 없어서 그냥 아무데이터나 넣음 ㅋㅋ
            else ->
                viewModel.getTagClubs("$data")
        }
        initAdapter()
        observePostWriteBodyState()
    }

    private fun observePostWriteBodyState() {
        viewModel.meetingList.flowWithLifecycle(lifecycle).onEach { state ->
            when (state) {
                is UiState.Success -> {
                    meetingAdapter.submitList(state.data)
                }

                is UiState.Failure -> {}

                is UiState.Loading -> return@onEach

                is UiState.Empty -> return@onEach
            }
        }.launchIn(lifecycleScope)
    }

    private fun initAdapter() {
        meetingAdapter = MeetingAdapter(navigate = {
            startActivity(Intent(requireContext(), JoinMeetingActivity::class.java))
        })
        binding.rvMeetingList.adapter = meetingAdapter
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

