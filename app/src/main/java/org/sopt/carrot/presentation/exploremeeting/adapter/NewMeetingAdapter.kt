package org.sopt.carrot.presentation.exploremeeting.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import org.sopt.carrot.core.ui.view.ItemDiffCallback
import org.sopt.carrot.databinding.ItemMeetingNewBinding
import org.sopt.carrot.presentation.exploremeeting.viewholder.NewMeetingViewHolder
import org.sopt.carrot.presentation.model.NewMeeting

class NewMeetingAdapter(
) : ListAdapter<NewMeeting, NewMeetingViewHolder>(
NewMeetingDiffCalback
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewMeetingViewHolder {
        val binding =
            ItemMeetingNewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewMeetingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewMeetingViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val NewMeetingDiffCalback =
            ItemDiffCallback<NewMeeting>(
                onItemsTheSame = { old, new -> old.title == new.title },
                onContentsTheSame = { old, new -> old == new }
            )
    }
}