package com.example.movieapp.data.network.model

import com.example.movieapp.domain.model.Genres
import com.google.gson.annotations.SerializedName

data class GenreDto(
    @SerializedName("genres")
    val genres: Genres
)