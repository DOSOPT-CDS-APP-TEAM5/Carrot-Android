package org.sopt.carrot.presentation.joinmeeting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import coil.load
import coil.transform.RoundedCornersTransformation
import org.sopt.carrot.R
import org.sopt.carrot.data.api.CarrotService
import org.sopt.carrot.data.api.RetrofitServicePool
import org.sopt.carrot.data.model.join_meeting.JoinMeetingData
import org.sopt.carrot.data.model.join_meeting.ResponseJoinMeetingDto
import org.sopt.carrot.databinding.ActivityJoinMeetingBinding
import retrofit2.Call
import retrofit2.Response

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

        getInfo()
    }

    private fun getInfo() {
        RetrofitServicePool.carrotService.getInfo(1)
            .enqueue(object : retrofit2.Callback<ResponseJoinMeetingDto> {
                override fun onResponse(
                    call: Call<ResponseJoinMeetingDto>,
                    response: Response<ResponseJoinMeetingDto>
                ) {
                    if (response.isSuccessful) {
                        val data: JoinMeetingData = response.body()!!.data
                        binding.tvJoinMeetingContent.text = data.clubContent
                        binding.tvJoinMeetingTitle.text = data.clubName
                        binding.ivJoinMeetingBackground.load(data.clubBackgroundImg)
                        binding.ivJoinMeetingProfile.load(data.clubImg)
                        binding.ivJoinMeetingImage1.load(data.albums[0].albumImg)
                        binding.ivJoinMeetingImage2.load(data.albums[1].albumImg)
                        binding.ivJoinMeetingImage3.load(data.albums[2].albumImg)
                        binding.ivJoinMeetingImage4.load(data.albums[3].albumImg)
                        binding.ivJoinMeetingImage5.load(data.albums[4].albumImg)
                        Log.d("JoinMeetingActivity", "onResponse: Success, Club Content: ${data.clubContent}")
                    } else {
                        // Log the unsuccessful response
                        Log.e("JoinMeetingActivity", "onResponse: Unsuccessful, Code: ${response.code()}")
                    }
                }

                override fun onFailure(call: Call<ResponseJoinMeetingDto>, t: Throwable) {
                    Log.e("JoinMeetingActivity", "onFailure: ${t.message}", t)
                    Toast.makeText(this@JoinMeetingActivity, "서버 에러 발생", Toast.LENGTH_SHORT).show()
                }
            })
    }
}