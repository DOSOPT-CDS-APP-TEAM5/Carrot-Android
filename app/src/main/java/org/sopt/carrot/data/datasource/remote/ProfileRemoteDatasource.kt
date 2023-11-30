package org.sopt.carrot.data.datasource.remote

import org.sopt.carrot.data.api.CarrotService
import org.sopt.carrot.data.model.BaseResponse
import org.sopt.carrot.data.model.neighborhoodlife.LivesResponse
import org.sopt.carrot.data.model.neighborhoodlife.request.ProfileRequest

class ProfileRemoteDatasource(
    private val carrotService: CarrotService
) {
    suspend fun postProfile(id: Int, nickname: String, information: String): BaseResponse<String> =
        carrotService.postProfile(id, ProfileRequest(nickname, information))
}