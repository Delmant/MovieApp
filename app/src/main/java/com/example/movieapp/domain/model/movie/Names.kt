package com.example.movieapp.domain.model.movie

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Names(
    val language: String,
    val name: String,
    val type: String
) : Parcelable