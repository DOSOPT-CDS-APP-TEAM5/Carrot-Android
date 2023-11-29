package org.sopt.carrot.presentation.exploremeeting.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import org.sopt.carrot.core.ui.view.ItemDiffCallback
import org.sopt.carrot.data.model.Meeting
import org.sopt.carrot.databinding.ItemMeetingBinding
import org.sopt.carrot.presentation.exploremeeting.viewholder.MeetingViewHolder
import java.lang.Integer.min

class MeetingAdapter(
    private val navigate: (Meeting) -> Unit = { _ -> }
) : ListAdapter<Meeting, MeetingViewHolder>(
    HighLightDiffCalback
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MeetingViewHolder {
        val binding =
            ItemMeetingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MeetingViewHolder(binding, navigate)
    }

    override fun onBindViewHolder(holder: MeetingViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemCount(): Int {
        return min(super.getItemCount(), 3)
    }

    companion object {
        private val HighLightDiffCalback =
            ItemDiffCallback<Meeting>(
                onItemsTheSame = { old, new -> old.clubId == new.clubId },
                onContentsTheSame = { old, new -> old == new }
            )
    }
}