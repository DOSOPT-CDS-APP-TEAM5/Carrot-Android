package org.sopt.carrot.presentation.exploremeeting.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import org.sopt.carrot.core.ui.view.ItemDiffCallback
import org.sopt.carrot.databinding.ItemMeetingHighlightBinding
import org.sopt.carrot.presentation.exploremeeting.viewholder.HighlightViewHolder
import org.sopt.carrot.presentation.model.MeetingHighlight

class HighlightAdapter(
) : ListAdapter<MeetingHighlight, HighlightViewHolder>(
    HighLightDiffCalback
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HighlightViewHolder {
        val binding =
            ItemMeetingHighlightBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HighlightViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HighlightViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val HighLightDiffCalback =
            ItemDiffCallback<MeetingHighlight>(
                onItemsTheSame = { old, new -> old.title == new.title },
                onContentsTheSame = { old, new -> old == new }
            )
    }
}