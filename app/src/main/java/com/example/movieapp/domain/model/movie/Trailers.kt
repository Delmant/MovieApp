package com.example.movieapp.domain.model.movie

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Trailers(
    val name: String,
    val site: String,
    val size: Int,
    val type: String,
    val url: String
) : Parcelable