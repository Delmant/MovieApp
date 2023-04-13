package com.example.movieapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ReleaseYear(
    val end: Int,
    val start: Int
) : Parcelable