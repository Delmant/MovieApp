package com.example.movieapp.data.remote_data_source.model.movie_list_dto

import com.example.movieapp.data.remote_data_source.model.movie_dto.MovieDto
import com.google.gson.annotations.SerializedName

data class MovieListDto(
    @SerializedName("docs")
    val list: List<MovieDto>
)