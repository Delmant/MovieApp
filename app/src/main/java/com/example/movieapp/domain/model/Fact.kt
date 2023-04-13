package com.example.movieapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Fact(
    val spoiler: Boolean,
    val type: String,
    val value: String
) : Parcelable