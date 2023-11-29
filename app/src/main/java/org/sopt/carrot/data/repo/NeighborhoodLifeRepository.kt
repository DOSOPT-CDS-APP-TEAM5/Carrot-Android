package org.sopt.carrot.data.repo

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.sopt.carrot.data.datasource.remote.NeighborhoodLifeRemoteDatasource
import org.sopt.carrot.data.model.neighborhoodlife.LivesDataResponse

class NeighborhoodLifeRepository(
    private val neighborhoodLifeRemoteDatasource: NeighborhoodLifeRemoteDatasource
) {
    suspend fun getLives(): List<LivesDataResponse> =
        withContext(Dispatchers.IO) {
            neighborhoodLifeRemoteDatasource.getLives()
        }
}