package org.sopt.carrot.presentation.exploremeeting

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.sopt.carrot.core.ui.view.UiState
import org.sopt.carrot.data.model.Meeting
import org.sopt.carrot.data.repo.ExploreMeetingRepository
import org.sopt.carrot.presentation.model.MeetingHighlight
import org.sopt.carrot.presentation.model.NewMeeting

class ExploreMeetingViewModel(
    private val exploreMeetingRepo: ExploreMeetingRepository
) : ViewModel() {
    private val _meetingList = MutableStateFlow<UiState<List<Meeting>?>>(UiState.Empty)
    val meetingList: StateFlow<UiState<List<Meeting>?>> = _meetingList

    fun getClubs() {
        Log.d("http", "http")
        viewModelScope.launch {
            _meetingList.value = UiState.Loading
            runCatching {
                exploreMeetingRepo.getClubs()
            }.onSuccess {
                Log.d("success", "${it.data}")
                _meetingList.value = UiState.Success(it.data)
            }.onFailure {
                Log.d("fail", "${it}")
                _meetingList.value = UiState.Failure(it.message.toString())
            }
        }
    }

    fun getTagClubs(category: String) {
        Log.d("http", "http")
        viewModelScope.launch {
            _meetingList.value = UiState.Loading
            runCatching {
                exploreMeetingRepo.getTagClubs(category)
            }.onSuccess {
                Log.d("success", "${it.data}")
                _meetingList.value = UiState.Success(it.data)
            }.onFailure {
                Log.d("fail", "${it}")
                _meetingList.value = UiState.Failure(it.message.toString())
            }
        }
    }

    val meetingMockList = mutableListOf(
        Meeting(
            1,
            "test",
            "test",
            "https://s3-alpha-sig.figma.com/img/e98d/d5fe/144a3365727aa3de5419a5a3def7a2e2?Expires=1701648000&Signature=lvBRV5K0xrWoJbDJEBW9TVkJWHjf4KK6hsEbesoF3Mf2BSDlS7o0cdzX5a78ZVkL0aKOlGKrPJRl1vLMRIBGIFGtuEpsdpm3E-jZ8JCHSeIeteFFfYgmTNCWYGPW9awjAxnahqKcXanAqiOcugmdXZLzHI39hajQrzAaIZK9wpOHH5fOAPpydrK4cb1ywbKXkGbqyYpcK6wimZjjuIOofTkDBkdAvct8YPR3XiBft~nbcTjpNnkJ2O7ecVblLaRFmeQK~VUEOMYGf~M6vACZi1ao6kJ84ZelNfM0GbbaECidMzHLJ316DbJtEArvB21z2NIRdZzC7q7EZ9yBfKGZOQ__&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4",
            "",
            "test",
            111,
        ),
        Meeting(
            2,
            "test",
            "test",
            "https://s3-alpha-sig.figma.com/img/e98d/d5fe/144a3365727aa3de5419a5a3def7a2e2?Expires=1701648000&Signature=lvBRV5K0xrWoJbDJEBW9TVkJWHjf4KK6hsEbesoF3Mf2BSDlS7o0cdzX5a78ZVkL0aKOlGKrPJRl1vLMRIBGIFGtuEpsdpm3E-jZ8JCHSeIeteFFfYgmTNCWYGPW9awjAxnahqKcXanAqiOcugmdXZLzHI39hajQrzAaIZK9wpOHH5fOAPpydrK4cb1ywbKXkGbqyYpcK6wimZjjuIOofTkDBkdAvct8YPR3XiBft~nbcTjpNnkJ2O7ecVblLaRFmeQK~VUEOMYGf~M6vACZi1ao6kJ84ZelNfM0GbbaECidMzHLJ316DbJtEArvB21z2NIRdZzC7q7EZ9yBfKGZOQ__&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4",
            "",
            "test",
            111,
        ),
        Meeting(
            3,
            "test",
            "test",
            "https://s3-alpha-sig.figma.com/img/e98d/d5fe/144a3365727aa3de5419a5a3def7a2e2?Expires=1701648000&Signature=lvBRV5K0xrWoJbDJEBW9TVkJWHjf4KK6hsEbesoF3Mf2BSDlS7o0cdzX5a78ZVkL0aKOlGKrPJRl1vLMRIBGIFGtuEpsdpm3E-jZ8JCHSeIeteFFfYgmTNCWYGPW9awjAxnahqKcXanAqiOcugmdXZLzHI39hajQrzAaIZK9wpOHH5fOAPpydrK4cb1ywbKXkGbqyYpcK6wimZjjuIOofTkDBkdAvct8YPR3XiBft~nbcTjpNnkJ2O7ecVblLaRFmeQK~VUEOMYGf~M6vACZi1ao6kJ84ZelNfM0GbbaECidMzHLJ316DbJtEArvB21z2NIRdZzC7q7EZ9yBfKGZOQ__&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4",
            "",
            "test",
            111,
        ),
    )
    val newMeetingMockList = mutableListOf(
        NewMeeting(
            "https://s3-alpha-sig.figma.com/img/e98d/d5fe/144a3365727aa3de5419a5a3def7a2e2?Expires=1701648000&Signature=lvBRV5K0xrWoJbDJEBW9TVkJWHjf4KK6hsEbesoF3Mf2BSDlS7o0cdzX5a78ZVkL0aKOlGKrPJRl1vLMRIBGIFGtuEpsdpm3E-jZ8JCHSeIeteFFfYgmTNCWYGPW9awjAxnahqKcXanAqiOcugmdXZLzHI39hajQrzAaIZK9wpOHH5fOAPpydrK4cb1ywbKXkGbqyYpcK6wimZjjuIOofTkDBkdAvct8YPR3XiBft~nbcTjpNnkJ2O7ecVblLaRFmeQK~VUEOMYGf~M6vACZi1ao6kJ84ZelNfM0GbbaECidMzHLJ316DbJtEArvB21z2NIRdZzC7q7EZ9yBfKGZOQ__&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4",
            "주식 투자(트레이딩)",
            "다양한 기법으로 투자(트레이딩)하는 관점",
            "정자동",
            "투자/금융"
        ),
        NewMeeting(
            "https://s3-alpha-sig.figma.com/img/8223/d69a/0fc6bbb2b464726d781d25c89db87f04?Expires=1701648000&Signature=PhPieULim~ElKVdUWzXLLSEBGigRwpf6J7otvr-MzID-1FiUfJAh-IjDmWRHXYGamOMoBM7140zAktsB-qdl4dk1DmLilEbHxRStuImgtX79in81zcSjMio6wBQISIG3N3d0poss31JLpzcgg5Y5SL7qT2FAtRDr-Uj060zFILGHf9QsdkCR4xR18NDOIsl6kupkDvetjR~Q6H3Gt1Apk8mjkmtneeVfLwCais7gXZkQhEFDS873qir8azYoiuBmbix9IbjXPCGS2q33y6Jq8dNiHBROODpUwR8GByKPGHO5FYJJHhWBy31JwCqdHpp3uMAQ-ZaqHdH6amRHm7QS5Q__&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4",
            "음악회 / 전시회 동아리",
            "음악회나 전시회 같이 보러 다닐 친구 구해요",
            "상현1동",
            "운동"
        ),
        NewMeeting(
            "https://s3-alpha-sig.figma.com/img/3ac0/089f/72c9ce99895093fa2bff131caa59a44e?Expires=1701648000&Signature=QmpM3QLc6NaptJjsAQp5vezUWG066aqrZnx6gV3h7XBpN8rCDbJk~qBK8AfbsJXnyVZDaKzuuWfvLo7sNBHhKXsKTmtZPUJPGC1uymGkzKKZFCkvLNZ4mzaQFvopQvJVai2pgsshYHtYpBzD1MYSbR~bbQHQo7XuoZj-dvR0MLHnRSl1qZn~E-qzajHA1QtQTREdZPYPV1q3zVnlbiS5ePTWj2B6OrP-74JI-kKkxtryxYP9ydtz1Y-1qAcwmXb7I3yDF9myNOuJYfXqIfa~RTVFo6h7GssXoYoFKm6td5I8OuSDxopxRPqec8nkofXh5Xrrz0ZEyC-5LrZKlHx~2w__&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4",
            "광교 드림FC",
            "매주 일요일 아침 광교 또는 인근 운동",
            "광교1동",
            "운동"
        ),
    )
    val meetingHighlightMockList = mutableListOf(
        MeetingHighlight(
            "https://s3-alpha-sig.figma.com/img/46c1/1a87/d715778de93a15555427a628cfc32fd8?Expires=1701648000&Signature=Cv~-ho5v4vvzOn4dKfhpxkOAryZYS5bSf~CHTBrzDMDa2GxYxa6MN4nXX8WENwp7XxPnykKDtm9O-BqON77ur-Hjq-fZ8P10d24~lvpnkz6sQkH53Z0DaLlqq5rEb1AkLs0pFKRB6cotTWyTMkNHpRZYHux8l9A5d5PUDRI8TrhuaV0Z~IRdFCblB0fMBK~9otsQb2riIkYeWY95fkQ4swNmf8V44Y-sKHPzPJHdCSPYV6ei5PCRd-iC2Wqt~irbcm7832fuBEJLv72IC73YEitdO2dkAE9v3WXox0r7n5DsIFqj96s566E5Nj6AXCoxKbX0Ty3NQMQjjT40sz~NZg__&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4",
            "러닝크루"
        ),
        MeetingHighlight(
            "https://s3-alpha-sig.figma.com/img/8f15/d2e9/c978cfc0eca29b0817d8e99974085fab?Expires=1701648000&Signature=n5zM~zetHmUOObs3uNLnrmEIKR4e5vneYWbwxXAKXtXjcb4PFuCxfeILgxyhBEPOpd-zhjUXCO0y7ucIa-WbMF2xBeG6TuLE5dvU0mWtLHk3dE4LXe3UiD5WYVrltcM~uTYMt1FDUdEypXuDepXfqFLGB9MCT3~cvrAKsqx-zMW74SsaSUy-kh~pBLjHxIuVeS24DAT2WDQC0gsOfINXYf46R3AFWl02z2~BKXtNcZo4iJ5A~Fb0g3bIlpbV8y3xjqNI6HES7-8so4Zpq029aBk9o~U0T8q25btETjovEh-qBha3LJPzTvcm4RZF~bznuPKA8Ue6VARYzqYmoTLSiA__&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4",
            "원데이클라스"
        ),
        MeetingHighlight(
            "https://s3-alpha-sig.figma.com/img/ecaa/202c/06d71a9139250ecb0bb212d23342da2a?Expires=1701648000&Signature=HPJs0DIffpEhh5kX~pOexNJ5wXWn2Ou5JghJUP1xQOtJLR5~2BNOEWKXvqgtFbUumEHE-yMgnyn1rVLLE8PQLn7kf1D~BPwn4x6-CwVzxDpTQFobJ3jp7pPYCZxGy22FnpestPwV1r6pQ1yT~0kOrFjAwdejI10gHK5qRVlRjmeZ3CgM7EDaM0zBdg2ppOuy1wkhhmE5GjjWV~Yb-ByCZKbpzuThla1NA9LPbtgwqeRizn5wCGyyQUTNF9BhSv3iUYMq8zzrENlY3hFjNbUJ345l3vhOX4TesQ2CLHQ2ybNFoxSmu69R7MSHJiIW4-CBlHSQ6wN~XyP8WqQ1J0eBBA__&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4",
            "영어 회화"
        )
    )

}