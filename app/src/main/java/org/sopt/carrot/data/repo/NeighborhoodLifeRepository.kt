package org.sopt.carrot.data.repo

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.sopt.carrot.data.datasource.remote.NeighborhoodLifeRemoteDatasource
import org.sopt.carrot.data.model.neighborhoodlife.LivesDataResponse
import kotlin.coroutines.coroutineContext

class NeighborhoodLifeRepository(
    private val neighborhoodLifeRemoteDatasource: NeighborhoodLifeRemoteDatasource
) {
    suspend fun getLives(category: String): List<LivesDataResponse> =
        withContext(Dispatchers.IO) {
            neighborhoodLifeRemoteDatasource.getLives(category)
        }
}