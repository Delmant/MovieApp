package com.example.movieapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Teaser(
    val name: String,
    val site: String,
    val size: Int,
    val type: String,
    val url: String
) : Parcelable