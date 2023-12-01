package org.sopt.carrot.data.datasource.remote

import org.sopt.carrot.data.api.CarrotService
import org.sopt.carrot.data.model.BaseResponse
import org.sopt.carrot.data.model.Meeting

class ExploreMeetingDataSource(
    private val carrotService: CarrotService
) {
    suspend fun getClubs(
    ): BaseResponse<List<Meeting>> = carrotService.getClubs()

    suspend fun getTagClubs(
        category: String
    ): BaseResponse<List<Meeting>> = carrotService.getTagClubs(category)
}