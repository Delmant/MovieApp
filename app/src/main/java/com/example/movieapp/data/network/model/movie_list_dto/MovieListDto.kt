package com.example.movieapp.data.network.model.movie_list_dto

import com.example.movieapp.data.network.model.movie_dto.MovieDto
import com.google.gson.annotations.SerializedName

data class MovieListDto(
    @SerializedName("docs")
    val list: List<MovieDto>
)