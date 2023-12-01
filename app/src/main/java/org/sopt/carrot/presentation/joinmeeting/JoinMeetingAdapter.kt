package org.sopt.carrot.presentation.joinmeeting

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.carrot.data.model.join_meeting.RecyclerData
import org.sopt.carrot.databinding.ItemJoinMeetingBinding

class JoinMeetingAdapter(context: Context) : RecyclerView.Adapter<RecyclerHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }

    private var infoList: List<RecyclerData> = emptyList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerHolder {
        val binding = ItemJoinMeetingBinding.inflate(inflater, parent, false)
        return RecyclerHolder(binding)
    }

    override fun getItemCount() = infoList.size

    override fun onBindViewHolder(holder: RecyclerHolder, position: Int) {
        holder.onBind(infoList[position])
    }

    fun setInfoList(infoList: List<RecyclerData>) {
        this.infoList = infoList.toList()
        notifyDataSetChanged()
    }
}