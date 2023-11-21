package org.sopt.carrot.presentation.joinmeeting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.load
import coil.transform.RoundedCornersTransformation
import org.sopt.carrot.R
import org.sopt.carrot.databinding.ActivityJoinMeetingBinding

class JoinMeetingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityJoinMeetingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJoinMeetingBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.ivJoinMeetingProfile.load("https://github-production-user-asset-6210df.s3.amazonaws.com/98076050/275424965-975a57c1-1581-4283-9613-5486b67986de.jpeg") {
            crossfade(true) //fade in 애니메이션
            error(R.drawable.ic_launcher_foreground) //Load Error 시 보여줄 이미지
            transformations(RoundedCornersTransformation(42F)) // 이미지를 원형으로 자르는 편집 기능 사용
        }
    }
}