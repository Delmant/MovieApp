package com.example.movieapp.domain.model.movie

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Premiere(
    val bluray: String,
    val cinema: String,
    val country: String,
    val digital: String,
    val dvd: String,
    val russia: String,
    val world: String
) : Parcelable