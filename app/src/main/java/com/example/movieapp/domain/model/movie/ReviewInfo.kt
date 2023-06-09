package com.example.movieapp.domain.model.movie

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ReviewInfo(
    val count: Int,
    val percentage: String,
    val positiveCount: Int
) : Parcelable