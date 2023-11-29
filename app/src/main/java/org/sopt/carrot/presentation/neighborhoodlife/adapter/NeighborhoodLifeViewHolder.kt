package org.sopt.carrot.presentation.neighborhoodlife.adapter

import androidx.recyclerview.widget.RecyclerView
import org.sopt.carrot.data.model.neighborhoodlife.LivesDataResponse
import org.sopt.carrot.databinding.ItemNeighborhoodContentsBinding

class NeighborhoodLifeViewHolder(
    private val binding: ItemNeighborhoodContentsBinding
): RecyclerView.ViewHolder(binding.root) {
    fun bind(item: LivesDataResponse) {
        binding.tvNeighborhoodContentsTitle.text = item.lifeTitle
        binding.tvNeighborhoodContentsDescription.text = item.lifeContent
        binding.tvNeighborhoodContentsTopic.text = item.lifeCategoryContent
        binding.tvNeighborhoodContentsEtc.text = item.contentInformation
        binding.tvComment.text = item.commentCount.toString()
        binding.tvLike.text = item.likeCount.toString()
    }
}