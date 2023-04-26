package com.example.movieapp.domain.model.movie

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize

data class Videos(
    val teasers: List<Teasers>,
    val trailers: List<Trailers>
) : Parcelable