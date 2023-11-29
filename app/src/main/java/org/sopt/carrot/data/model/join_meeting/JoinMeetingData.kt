package org.sopt.carrot.data.model.join_meeting


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class JoinMeetingData(
    @SerialName("albums")
    val albums: List<JoinMeetingAlbum>,
    @SerialName("clubBackgroundImg")
    val clubBackgroundImg: String,
    @SerialName("clubCategory")
    val clubCategory: String,
    @SerialName("clubContent")
    val clubContent: String,
    @SerialName("clubImg")
    val clubImg: String,
    @SerialName("clubName")
    val clubName: String,
    @SerialName("participantCount")
    val participantCount: Int
)