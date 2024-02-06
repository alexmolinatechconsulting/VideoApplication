package com.video

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.VideoApplication
import com.video.data.VideoData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class VideoViewModel(): ViewModel() {

    private var _videos = MutableLiveData<List<VideoData>>()
    val videos: LiveData<List<VideoData>> = _videos

    fun getVideos(search : String) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = VideoApplication.instance.container!!
                .service.getVideos(search)

            val videoList = result.results

            if (videoList != null && videoList.isNotEmpty()) {
                _videos.postValue(videoList!!)
            }
        }
    }

    fun clearDeals() {
        _videos.value = emptyList()
    }
}