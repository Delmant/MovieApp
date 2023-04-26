package com.example.movieapp.domain.model.movie

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Facts(
    val spoiler: Boolean,
    val type: String,
    val value: String
) : Parcelable