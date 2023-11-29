package org.sopt.carrot.data.model.neighborhoodlife

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LivesDataResponse(
    @SerialName("lifeId")
    val lifeId: Int,
    @SerialName("lifeCategoryContent")
    val lifeCategoryContent: String,
    @SerialName("lifeTitle")
    val lifeTitle: String,
    @SerialName("lifeContent")
    val lifeContent: String,
    @SerialName("contentInformation")
    val contentInformation: String,
    @SerialName("likeCount")
    val likeCount: Int,
    @SerialName("commentCount")
    val commentCount: Int,
)