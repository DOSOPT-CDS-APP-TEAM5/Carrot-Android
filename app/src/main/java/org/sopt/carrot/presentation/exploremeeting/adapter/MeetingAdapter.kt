package org.sopt.carrot.presentation.exploremeeting.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import org.sopt.carrot.core.ui.view.ItemDiffCallback
import org.sopt.carrot.databinding.ItemMeetingBinding
import org.sopt.carrot.presentation.exploremeeting.viewholder.MeetingViewHolder
import org.sopt.carrot.presentation.model.Meeting

class MeetingAdapter(
) : ListAdapter<Meeting, MeetingViewHolder>(
    HighLightDiffCalback
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MeetingViewHolder {
        val binding =
            ItemMeetingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MeetingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MeetingViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val HighLightDiffCalback =
            ItemDiffCallback<Meeting>(
                onItemsTheSame = { old, new -> old.clubId == new.clubId },
                onContentsTheSame = { old, new -> old == new }
            )
    }
}