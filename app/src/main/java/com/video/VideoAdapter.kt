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

class VideoAdapter(
    private var dataSet: List<VideoData>
) : RecyclerView.Adapter<VideoAdapter.VideoViewHolder>() {

    private var context : Context? = null

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): VideoViewHolder {

        context = parent.context

        return VideoViewHolder(
            VideoDataBinding.inflate(
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

        var requestOptions = RequestOptions()
        requestOptions = requestOptions.transform(FitCenter(), RoundedCorners(16))
    }

    override fun getItemCount(): Int = dataSet.size

    fun updateDataSet(newDataSet: List<VideoData>) {
        dataSet = newDataSet
        notifyDataSetChanged()
    }

    inner class VideoViewHolder(
        binding: VideoDataBinding
    ) : RecyclerView.ViewHolder(binding.root) {

    }
}
