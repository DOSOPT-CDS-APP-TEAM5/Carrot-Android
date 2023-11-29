package org.sopt.carrot.presentation.neighborhoodlife.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.RoundedCornersTransformation
import org.sopt.carrot.core.ui.view.ItemDiffCallback
import org.sopt.carrot.databinding.ItemNeighborhoodMeetingBinding
import org.sopt.carrot.presentation.neighborhoodlife.dummy.CarouselText

class CarouselTextAdapter : ListAdapter<CarouselText, CarouselTextViewHolder>(
    ItemDiffCallback<CarouselText>(
        onItemsTheSame = { old, new -> old == new },
        onContentsTheSame = { old, new -> old.id == new.id }
    )
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarouselTextViewHolder {
        return CarouselTextViewHolder(
            ItemNeighborhoodMeetingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CarouselTextViewHolder, position: Int) {
        holder.bind(currentList[position])
    }
}

class CarouselTextViewHolder(private val binding: ItemNeighborhoodMeetingBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: CarouselText) {
        binding.ivNeighborhoodMeeting.load(item.imageUrl) {
            transformations(RoundedCornersTransformation(50f))
        }
        binding.tvNeighborhoodMeeting.text = item.title
    }
}