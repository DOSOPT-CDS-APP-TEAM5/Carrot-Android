package org.sopt.carrot.data.api

import org.sopt.carrot.data.model.neighborhoodlife.LivesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NeighborhoodLifeService {
    @GET("api/lives")
    fun getLives(
        @Query("category") category: String
    ): LivesResponse
}