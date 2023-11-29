package org.sopt.carrot.data.api

import org.sopt.carrot.data.model.join_meeting.ResponseJoinMeetingDto
import org.sopt.carrot.data.model.neighborhoodlife.LivesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CarrotService {
    @GET("api/lives")
    fun getLives(
        @Query("category") category: String
    ): LivesResponse

    @GET("api/lives")
    suspend fun getLives(): LivesResponse

    @GET("api/clubs/{clubId}")
    fun getInfo(
        @Path("clubId") clubId: Int
    ): Call<ResponseJoinMeetingDto>
}