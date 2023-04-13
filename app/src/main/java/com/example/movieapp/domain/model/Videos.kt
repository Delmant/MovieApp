package com.example.movieapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize

data class Videos(
    val teasers: List<Teaser>,
    val trailers: List<Trailer>
) : Parcelable