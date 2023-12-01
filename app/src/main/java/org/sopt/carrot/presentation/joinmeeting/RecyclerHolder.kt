package org.sopt.carrot.presentation.joinmeeting

import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import org.sopt.carrot.R
import org.sopt.carrot.data.model.join_meeting.RecyclerData
import org.sopt.carrot.databinding.ItemJoinMeetingBinding


class RecyclerHolder(private val binding: ItemJoinMeetingBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun onBind(infoData: RecyclerData) {
        if (infoData.category == "공지글") {
            val noticeTextColor: Int =
                ContextCompat.getColor(itemView.context, R.color.carrot_primary_button)
            binding.tvJoinMeetingRvTitle.setTextColor(noticeTextColor)
        }
        binding.tvJoinMeetingRvTitle.text = infoData.category
        binding.tvJoinMeetingRvContent.text = infoData.content
        binding.tvJoinMeetingRvLikeNum.text = infoData.num.toString()
    }
}