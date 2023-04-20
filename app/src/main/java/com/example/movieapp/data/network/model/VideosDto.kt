package com.example.movieapp.data.network.model

import com.google.gson.annotations.SerializedName

data class VideosDto(
    @SerializedName("trailers")
    val trailerDtos: List<TrailerDto>,
    @SerializedName("teasers")
    val teaserDtos: List<TeaserDto>
)