package org.sopt.carrot.presentation.exploremeeting.viewholder

import androidx.recyclerview.widget.RecyclerView
import org.sopt.carrot.databinding.ItemMeetingNewBinding
import org.sopt.carrot.presentation.model.NewMeeting

class NewMeetingViewHolder(
    private val binding: ItemMeetingNewBinding,
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(data: NewMeeting) {
        binding.newmeeting = data
        binding.executePendingBindings()
    }
}