package com.kamil.moviesapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView
import com.kamil.moviesapp.R

class VideoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)

        //val etSearch: EditText = findViewById(R.id.etSearch)
        val videoView: VideoView = findViewById(R.id.vvVideoView)
        val videoPath: String = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/WhatCarCanYouGetForAGrand.mp4"

        videoView.setVideoPath(videoPath)

        val mediaController = MediaController(this)
        videoView.setMediaController(mediaController)
        mediaController.setAnchorView(videoView)

        videoView.start()
    }
}