package org.sopt.carrot.presentation.exploremeeting.viewholder

import androidx.recyclerview.widget.RecyclerView
import org.sopt.carrot.databinding.ItemMeetingBinding
import org.sopt.carrot.presentation.model.Meeting

class MeetingViewHolder(
    private val binding: ItemMeetingBinding,
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(data: Meeting) {
        binding.meeting = data
        binding.executePendingBindings()
    }
}