package org.sopt.carrot.presentation.model

data class Meeting(
    val clubId: Int,
    val clubTagContent: String,
    val clubName: String,
    val clubImg: String,
    val participantsImg: String,
    val town: String,
    val participantsCount: Int
)