package org.sopt.carrot.presentation.exploremeeting

import android.os.Bundle
import android.util.Log
import android.view.View
import org.sopt.carrot.R
import org.sopt.carrot.core.ui.base.BindingFragment
import org.sopt.carrot.databinding.ItemFragmentMeetingBinding

class ScreenMeetingSlideFragment :
    BindingFragment<ItemFragmentMeetingBinding>(R.layout.item_fragment_meeting) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data = arguments?.getString("data")
        Log.d("test","$data")
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

