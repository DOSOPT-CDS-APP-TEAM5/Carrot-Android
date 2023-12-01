package org.sopt.carrot.data.model.join_meeting


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class JoinMeetingAlbum(
    @SerialName("albumImg")
    val albumImg: String
)