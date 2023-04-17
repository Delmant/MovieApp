package com.example.movieapp.data.network.model

import com.example.movieapp.domain.model.Videos
import com.google.gson.annotations.SerializedName

data class VideosDto(
    @SerializedName("videos")
    val videos: Videos
)