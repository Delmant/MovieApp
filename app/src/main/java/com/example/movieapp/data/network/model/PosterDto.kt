package com.example.movieapp.data.network.model

import com.example.movieapp.domain.model.Poster
import com.google.gson.annotations.SerializedName

data class PosterDto(
    @SerializedName("poster")
    val poster: Poster
)