package com.example.movieapp.domain.model.movie

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ReleaseYears(
    val end: Int,
    val start: Int
) : Parcelable