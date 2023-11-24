package org.sopt.carrot.presentation.exploremeeting.viewholder

import androidx.recyclerview.widget.RecyclerView
import org.sopt.carrot.databinding.ItemMeetingHighlightBinding
import org.sopt.carrot.presentation.model.MeetingHighlight

class HighlightViewHolder(
    private val binding: ItemMeetingHighlightBinding,
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(data: MeetingHighlight) {
        binding.highlight = data
        binding.executePendingBindings()
    }
}