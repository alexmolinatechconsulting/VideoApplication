package com.video

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.FitCenter
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.video.data.VideoData
import com.videoapplication.R
import com.videoapplication.databinding.ItemVideoBinding

class VideoAdapter(
    private var dataSet: List<VideoData>
) : RecyclerView.Adapter<VideoAdapter.VideoViewHolder>() {

    private var context : Context? = null

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): VideoViewHolder {

        context = parent.context

        return VideoViewHolder(
            ItemVideoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(
        holder: VideoViewHolder, position: Int
    ) {

        val item = dataSet[position]
        val title = item.results!!.title

        var requestOptions = RequestOptions()
        requestOptions = requestOptions.transform(FitCenter(), RoundedCorners(16))
        Glide
            .with(context!!)
            .load("${item.results.poster_path}")
            .apply(requestOptions)
            .skipMemoryCache(true)
            .placeholder(R.drawable.placeholder)
            .into(holder.videoPosterPath)
    }

    override fun getItemCount(): Int = dataSet.size

    fun updateDataSet(newDataSet: List<VideoData>) {
        dataSet = newDataSet
        notifyDataSetChanged()
    }

    inner class VideoViewHolder(
        binding: ItemVideoBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        val videoTitle : TextView
        val videoPosterPath : ImageView

        init {
            videoTitle = binding.videoTitle
            videoPosterPath = binding.videoPosterPath
        }
    }
}
