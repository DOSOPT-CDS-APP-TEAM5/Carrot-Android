package org.sopt.carrot.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Meeting(
    @SerialName("clubId")
    val clubId: Int,
    @SerialName("clubCategoryContent")
    val clubTagContent: String,
    @SerialName("clubName")
    val clubName: String,
    @SerialName("clubImg")
    val clubImg: String,
    @SerialName("participantsImg")
    val participantsImg: String,
    @SerialName("town")
    val town: String,
    @SerialName("participantCount")
    val participantsCount: Int
)