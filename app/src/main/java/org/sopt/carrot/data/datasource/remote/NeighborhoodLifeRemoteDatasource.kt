package org.sopt.carrot.data.datasource.remote

import org.sopt.carrot.data.api.CarrotService
import org.sopt.carrot.data.model.neighborhoodlife.LivesDataResponse

class NeighborhoodLifeRemoteDatasource(
    private val carrotService: CarrotService
) {
    suspend fun getLives(): List<LivesDataResponse> =
        carrotService.getLives().data

    suspend fun getLives(category: String): List<LivesDataResponse> =
        carrotService.getLives(category).data
}