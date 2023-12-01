package org.sopt.carrot.data.model.neighborhoodlife.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProfileRequest(
    @SerialName("nickname")
    val nickname: String,
    @SerialName("information")
    val information: String,
)
