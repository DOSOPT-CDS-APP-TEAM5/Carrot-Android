package org.sopt.carrot.presentation.neighborhoodlife.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.sopt.carrot.core.ui.view.ItemDiffCallback
import org.sopt.carrot.databinding.ItemTopicBinding
import org.sopt.carrot.presentation.neighborhoodlife.dummy.carouselTagList

class CarouselTagAdapter : ListAdapter<String, CarouselTagViewHolder>(
    ItemDiffCallback<String>(
        onItemsTheSame = { old, new -> old == new },
        onContentsTheSame = { old, new -> old === new }
    )
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarouselTagViewHolder {
        return CarouselTagViewHolder(
            ItemTopicBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CarouselTagViewHolder, position: Int) {
        holder.bind(currentList[position])
    }
}

class CarouselTagViewHolder(
    private val binding: ItemTopicBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: String) {
        if (item == carouselTagList[0]) binding.ivTopic.visibility = View.VISIBLE
        binding.tvTopicTitle.text = item
    }
}