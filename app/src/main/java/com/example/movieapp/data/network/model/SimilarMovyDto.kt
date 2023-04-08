package com.example.movieapp.data.network.model

data class SimilarMovyDto(
    val alternativeName: String,
    val enName: String,
    val id: Int,
    val name: String,
    val posterDto: PosterDto,
    val type: String
)