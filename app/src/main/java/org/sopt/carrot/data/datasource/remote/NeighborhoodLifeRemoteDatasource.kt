package org.sopt.carrot.data.datasource.remote

import org.sopt.carrot.data.api.NeighborhoodLifeService
import org.sopt.carrot.data.model.neighborhoodlife.LivesDataResponse
import org.sopt.carrot.data.model.neighborhoodlife.LivesResponse
import retrofit2.Response

class NeighborhoodLifeRemoteDatasource(
    private val neighborhoodLifeService: NeighborhoodLifeService
) {
    suspend fun getLives(category: String): List<LivesDataResponse> {
        return neighborhoodLifeService.getLives(category).data
    }
}