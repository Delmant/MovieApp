package com.example.movieapp.data.network.model

data class VideosDto(
    val teaserDtos: List<TeaserDto>,
    val trailerDtos: List<TrailerDto>
)