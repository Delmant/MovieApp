package com.example.movieapp.domain.model

data class Votes(
    val await: Int,
    val filmCritics: Int,
    val imdb: String,
    val kp: String,
    val russianFilmCritics: Int,
    val tmdb: Int
)