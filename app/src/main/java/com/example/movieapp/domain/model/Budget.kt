package com.example.movieapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Budget(
    val value: Int,
    val currency: String
): Parcelable