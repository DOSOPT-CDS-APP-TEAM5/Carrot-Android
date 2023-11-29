package org.sopt.carrot.presentation.neighborhoodlife.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import org.sopt.carrot.core.ui.view.ItemDiffCallback
import org.sopt.carrot.data.model.neighborhoodlife.LivesDataResponse
import org.sopt.carrot.databinding.ItemNeighborhoodContentsBinding

class NeighborhoodLifeAdapter :
    ListAdapter<LivesDataResponse, NeighborhoodLifeViewHolder>(ItemDiffCallback<LivesDataResponse>(
        onItemsTheSame = { old, new -> old.lifeId == new.lifeId },
        onContentsTheSame = { old, new -> old == new }
    )
    ) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NeighborhoodLifeViewHolder {
        return NeighborhoodLifeViewHolder(
            ItemNeighborhoodContentsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: NeighborhoodLifeViewHolder, position: Int) {
        holder.bind(currentList[position])
    }
}