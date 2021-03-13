package com.kamil.moviesapp.data.network.response


data class Category(
    val name: String,
    val videos: ArrayList<VideoItem>
)