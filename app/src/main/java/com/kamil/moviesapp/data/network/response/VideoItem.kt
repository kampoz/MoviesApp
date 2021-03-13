package com.kamil.moviesapp.data.network.response


import com.google.gson.annotations.SerializedName

data class VideoItem(
    val description: String,
    val sources: List<String>?,
    val subtitle: String,
    val thumb: String,
    val title: String
)