package org.sopt.carrot.data.model.join_meeting

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes

@SuppressLint("SupportAnnotationUsage")
data class RecyclerData(
    @DrawableRes
    val category: String,
    val content: String,
    val num: Int,
)
