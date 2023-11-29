package org.sopt.carrot.data.model.neighborhoodlife

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LivesResponse(
    @SerialName("code")
    val code: Int,
    @SerialName("message")
    val message: String,
    @SerialName("data")
    val data: List<LivesDataResponse>
)

