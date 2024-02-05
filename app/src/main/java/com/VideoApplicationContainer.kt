package com

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import okhttp3.OkHttpClient

class VideoApplicationContainer {
    val baseUrl = ""
    val httpClient = OkHttpClient().newBuilder().build()
    val auth = FirebaseAuth.getInstance()
    val store = FirebaseFirestore.getInstance()
}