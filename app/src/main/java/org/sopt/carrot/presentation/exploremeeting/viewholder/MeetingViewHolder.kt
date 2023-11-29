package org.sopt.carrot.presentation.exploremeeting.viewholder

import androidx.recyclerview.widget.RecyclerView
import org.sopt.carrot.data.model.Meeting
import org.sopt.carrot.databinding.ItemMeetingBinding

class MeetingViewHolder(
    private val binding: ItemMeetingBinding,
    private val navigate: (Meeting) -> Unit = { _ -> }
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(data: Meeting) {
        binding.meeting = data
        binding.tvMeetingListCount.text = data.participantsCount.toString()+"명 · "
        binding.root.setOnClickListener {
            navigate(data)
        }
        binding.executePendingBindings()
    }
}