package org.sopt.carrot.data.model.join_meeting


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseJoinMeetingDto(
    @SerialName("code")
    val code: Int,
    @SerialName("data")
    val data: JoinMeetingData,
    @SerialName("message")
    val message: String
)