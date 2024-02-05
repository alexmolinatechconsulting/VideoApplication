package com

import android.app.Application
import com.google.firebase.FirebaseApp

class VideoApplication : Application() {

    init{
        instance = this
    }

    var container : VideoApplicationContainer? = null

    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this@VideoApplication)
        container = VideoApplicationContainer()
    }

    companion object {
        lateinit var instance : VideoApplication
            private set
    }
}