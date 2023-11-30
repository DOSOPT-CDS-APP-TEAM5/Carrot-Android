package org.sopt.carrot.data.repo

import org.sopt.carrot.data.datasource.remote.NeighborhoodLifeRemoteDatasource
import org.sopt.carrot.data.datasource.remote.ProfileRemoteDatasource
import org.sopt.carrot.data.model.BaseResponse
import org.sopt.carrot.data.model.neighborhoodlife.LivesResponse

class ProfileRepository(
    private val profileRemoteDatasource: ProfileRemoteDatasource
) {
    suspend fun postProfile(id: Int, nickname: String, information: String): BaseResponse<String> =
        profileRemoteDatasource.postProfile(id, nickname, information)
}