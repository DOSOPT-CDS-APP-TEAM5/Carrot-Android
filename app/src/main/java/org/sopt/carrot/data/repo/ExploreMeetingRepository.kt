package org.sopt.carrot.data.repo

import org.sopt.carrot.data.datasource.remote.ExploreMeetingDataSource
import org.sopt.carrot.data.model.BaseResponse
import org.sopt.carrot.data.model.Meeting

class ExploreMeetingRepository(
    private val exploreMeetingDataSource: ExploreMeetingDataSource
) {
    suspend fun getClubs(
    ): BaseResponse<List<Meeting>> = exploreMeetingDataSource.getClubs()

    suspend fun getTagClubs(
        category: String
    ): BaseResponse<List<Meeting>> = exploreMeetingDataSource.getTagClubs(category)
}