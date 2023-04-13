package com.example.movieapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ImagesInfo(
    val backdropsCount: Int,
    val framesCount: Int,
    val postersCount: Int
) : Parcelable