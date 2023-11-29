package org.sopt.carrot.presentation.joinmeeting

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import coil.load
import coil.transform.RoundedCornersTransformation
import org.sopt.carrot.R
import org.sopt.carrot.data.api.RetrofitServicePool
import org.sopt.carrot.data.model.join_meeting.JoinMeetingData
import org.sopt.carrot.data.model.join_meeting.RecyclerData
import org.sopt.carrot.data.model.join_meeting.ResponseJoinMeetingDto
import org.sopt.carrot.databinding.ActivityJoinMeetingBinding
import retrofit2.Call
import retrofit2.Response

class JoinMeetingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityJoinMeetingBinding

    private val mockRecyclerList = listOf<RecyclerData>(
        RecyclerData(
            category = "공지글",
            content = "요건 꼭 지켜주세요. 1. 운동 끝나고 쓰레기 치...",
            num = 2
        ),
        RecyclerData(
            category = "자유게시판",
            content = "내일 저녁 청계천에서 배드민턴 치실분 2분 ...",
            num = 2
        ),
        RecyclerData(
            category = "모임 후기",
            content = "오늘 너무 재밌었어요^^*~",
            num = 2
        ),
        RecyclerData(
            category = "자유게시판",
            content = "저는 탈퇴하겠습니다.",
            num = 2
        ),
        RecyclerData(
            category = "모임 후기",
            content = "11/14 모임 사진/배드민턴/닭계장에 소주",
            num = 2
        ),

        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJoinMeetingBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.ivJoinMeetingProfile.load("https://github-production-user-asset-6210df.s3.amazonaws.com/98076050/275424965-975a57c1-1581-4283-9613-5486b67986de.jpeg") {
            crossfade(true) //fade in 애니메이션
            error(R.drawable.ic_launcher_foreground) //Load Error 시 보여줄 이미지
            transformations(RoundedCornersTransformation(42F)) // 이미지를 원형으로 자르는 편집 기능 사용
        }
        getRecyclerList()
        getInfo()
    }

    private fun getInfo() {
        RetrofitServicePool.carrotService.getInfo(1)
            .enqueue(object : retrofit2.Callback<ResponseJoinMeetingDto> {
                override fun onResponse(
                    call: Call<ResponseJoinMeetingDto>,
                    response: Response<ResponseJoinMeetingDto>,
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
                        Log.d(
                            "JoinMeetingActivity",
                            "onResponse: Success, Club Content: ${data.clubContent}"
                        )
                    } else {
                        // Log the unsuccessful response
                        Log.e(
                            "JoinMeetingActivity",
                            "onResponse: Unsuccessful, Code: ${response.code()}"
                        )
                    }
                }

                override fun onFailure(call: Call<ResponseJoinMeetingDto>, t: Throwable) {
                    Log.e("JoinMeetingActivity", "onFailure: ${t.message}", t)
                    Toast.makeText(this@JoinMeetingActivity, "서버 에러 발생", Toast.LENGTH_SHORT).show()
                }
            })
    }

    private fun getRecyclerList() {
        val recyclerAdapter = JoinMeetingAdapter(this)
        binding.rvJoinMeeting.adapter = recyclerAdapter
        recyclerAdapter.setInfoList(mockRecyclerList)
    }
}