package com.example.movieapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Backdrop(
    val previewUrl: String,
    val url: String
) : Parcelable