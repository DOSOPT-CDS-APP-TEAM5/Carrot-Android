package org.sopt.carrot.data.api

import org.sopt.carrot.data.model.BaseResponse
import org.sopt.carrot.data.model.neighborhoodlife.LivesResponse
import org.sopt.carrot.data.model.neighborhoodlife.request.ProfileRequest
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import org.sopt.carrot.data.model.Meeting
import org.sopt.carrot.data.model.join_meeting.ResponseJoinMeetingDto
import retrofit2.Call
import retrofit2.http.Path
import retrofit2.http.Query

interface CarrotService {
    @GET("api/lives")
    suspend fun getLives(
        @Query("category") category: String
    ): LivesResponse

    @GET("api/lives")
    suspend fun getLives(): LivesResponse

    @POST("api/clubs/profile")
    suspend fun postProfile(
        @Header("X-Club-Id") id: Int,
        @Body profileRequest: ProfileRequest
    ): BaseResponse<String>

    @GET("api/clubs")
    suspend fun getTagClubs(
        @Query("category") category: String
    ): BaseResponse<List<Meeting>>

    @GET("api/clubs")
    suspend fun getClubs(
    ): BaseResponse<List<Meeting>>
  
    @GET("api/clubs/{clubId}")
    fun getInfo(
        @Path("clubId") clubId: Int
    ): Call<ResponseJoinMeetingDto>
  
}