package com.example.movieapp.domain.model.movie

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Votes(
    val await: Int,
    val filmCritics: Int,
    val imdb: String,
    val kp: String,
    val russianFilmCritics: Int,
    val tmdb: Int
) : Parcelable