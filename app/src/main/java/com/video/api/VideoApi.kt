package com.video.api

import com.video.data.VideoDataList
import com.videoapplication.BuildConfig
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface VideoApi {

    @GET(BuildConfig.ENDPOINT_VIDEO)
    suspend fun getVideos(
        @Header("Authorization") token : String, // bearer token
        @Query("query") query : String // search query
    ) : VideoDataList
}