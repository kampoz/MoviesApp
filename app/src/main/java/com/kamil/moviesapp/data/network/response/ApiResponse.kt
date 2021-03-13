package com.kamil.moviesapp.data.network.response


import com.google.gson.annotations.SerializedName

data class ApiResponse(
    val categories: List<Category>
)