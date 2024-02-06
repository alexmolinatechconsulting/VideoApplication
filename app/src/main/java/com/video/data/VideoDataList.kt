package com.video.data

import com.google.gson.annotations.SerializedName

data class VideoDataList(
    @SerializedName("page")
    val page : Int?,
    @SerializedName("results")
    val results : List<VideoData>?,
    @SerializedName("total_pages")
    val total_pages : Int?,
    @SerializedName("total_results")
    val total_results : Int?
)
