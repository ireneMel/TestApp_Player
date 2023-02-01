package com.miller.testapp_musicplayer

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.miller.testapp_musicplayer.databinding.HorizontalItemBinding
import com.miller.testapp_musicplayer.models.Video

class HorizontalAdapter : ListAdapter<Video, HorizontalAdapter.HorizontalViewHolder>(VideoDiff) {

    inner class HorizontalViewHolder(val binding: HorizontalItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    object VideoDiff : DiffUtil.ItemCallback<Video>() {
        override fun areItemsTheSame(oldItem: Video, newItem: Video): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Video, newItem: Video): Boolean =
            oldItem.hashCode() == newItem.hashCode()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HorizontalViewHolder {
        return HorizontalViewHolder(
            HorizontalItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: HorizontalAdapter.HorizontalViewHolder, position: Int) {
        val video = getItem(position)

        with(holder.binding) {
            horizontalVideoName.text = video.name
            horizontalChannelName.text = video.channel
            //TODO add horizontalImage via url using glide library
            videoItem.setOnClickListener {
                onVideoClickListener?.let {
                    it(video)
                }
            }
        }
    }

    private var onVideoClickListener: ((Video) -> Unit)? = null

    fun setOnVideoClickListener(listener: ((Video) -> Unit)) {
        onVideoClickListener = listener
    }
}