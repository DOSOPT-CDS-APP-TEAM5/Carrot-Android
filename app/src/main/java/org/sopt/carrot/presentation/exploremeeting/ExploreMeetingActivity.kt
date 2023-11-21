package org.sopt.carrot.presentation.exploremeeting

import android.content.Intent
import android.os.Bundle
import org.sopt.carrot.R
import org.sopt.carrot.core.ui.base.BindingActivity
import org.sopt.carrot.databinding.ActivityExploreMeetingBinding
import org.sopt.carrot.presentation.joinmeeting.JoinMeetingActivity

class ExploreMeetingActivity :
    BindingActivity<ActivityExploreMeetingBinding>(R.layout.activity_explore_meeting) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.btnSample.setOnClickListener {
            startActivity(Intent(this, JoinMeetingActivity::class.java))
        }
    }
}