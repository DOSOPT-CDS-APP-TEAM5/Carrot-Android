package org.sopt.carrot.data.repo

import org.sopt.carrot.data.datasource.remote.NeighborhoodLifeRemoteDatasource
import org.sopt.carrot.data.model.neighborhoodlife.LivesDataResponse

class NeighborhoodLifeRepository(
    private val neighborhoodLifeRemoteDatasource: NeighborhoodLifeRemoteDatasource
) {
    suspend fun getLives(): List<LivesDataResponse> =
        neighborhoodLifeRemoteDatasource.getLives()

    suspend fun getLives(category: String): List<LivesDataResponse> =
        neighborhoodLifeRemoteDatasource.getLives(category)
}