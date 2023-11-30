package org.sopt.carrot.data.datasource.remote

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import org.sopt.carrot.data.api.CarrotService
import org.sopt.carrot.data.model.neighborhoodlife.LivesDataResponse

class NeighborhoodLifeRemoteDatasource(
    private val carrotService: CarrotService
) {
    suspend fun getLives(): List<LivesDataResponse> {
        return carrotService.getLives().data
    }
}