package com.video.data

import com.google.gson.annotations.SerializedName

data class VideoData(
    @SerializedName("page")
    val page : Int?,
    @SerializedName("results")
    val results : VideoDataResults?,
    @SerializedName("total_pages")
    val total_pages : Int?,
    @SerializedName("total_results")
    val total_results : Int?
)
