package com.video.api

import com.VideoApplication
import com.video.data.VideoDataList
import com.videoapplication.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class VideoApiService {

    suspend fun getVideos(query: String) : VideoDataList {

        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(VideoApplication.instance.container!!.httpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(VideoApi::class.java)
        return service.getVideos(token = "Bearer ${BuildConfig.BEARER_TOKEN}", query = query)
    }
}