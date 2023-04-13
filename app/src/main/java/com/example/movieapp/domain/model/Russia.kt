package com.example.movieapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Russia(
    val currency: String,
    val value: Int
) : Parcelable