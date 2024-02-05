package com.video.api

import com.video.data.VideoData
import retrofit2.http.GET

interface VideoApi {

    @GET("{search}")
    suspend fun getVideos(search : String) : List<VideoData>
}