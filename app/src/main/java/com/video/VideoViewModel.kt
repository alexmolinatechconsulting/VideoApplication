package com.video

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.video.api.VideoApiService
import com.video.data.VideoData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class VideoViewModel constructor(
    private val videoApiService: VideoApiService
): ViewModel() {

    private var _videos = MutableLiveData<List<VideoData>>()
    val videos: LiveData<List<VideoData>> = _videos

    fun getVideos(search : String) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = videoApiService.getVideos(search)

            if (result.isNotEmpty()) {
                _videos.postValue(result)
            }
        }
    }
]
    fun clearDeals() {
        _videos.value = emptyList()
    }
}