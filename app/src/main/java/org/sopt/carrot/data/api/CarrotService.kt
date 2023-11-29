package org.sopt.carrot.data.api

import org.sopt.carrot.data.model.BaseResponse
import org.sopt.carrot.data.model.Meeting
import org.sopt.carrot.data.model.neighborhoodlife.LivesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CarrotService {
    @GET("api/lives")
    fun getLives(
        @Query("category") category: String
    ): LivesResponse

    @GET("api/lives")
    suspend fun getLives(): LivesResponse

    @GET("api/clubs")
    suspend fun getTagClubs(
        @Query("category") category: String
    ): BaseResponse<List<Meeting>>

    @GET("api/clubs")
    suspend fun getClubs(
    ): BaseResponse<List<Meeting>>
}