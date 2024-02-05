package com.video.api

import com.VideoApplication
import com.video.data.VideoData
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class VideoApiService {

    suspend fun getVideos(search: String) : List<VideoData> {

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(VideoApplication.instance.container!!.httpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(VideoApi::class.java)
        return service.getVideos(search)
    }
}