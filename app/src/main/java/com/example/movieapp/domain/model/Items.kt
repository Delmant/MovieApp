package com.example.movieapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Items(
    val logo: Logo,
    val name: String,
    val url: String
) : Parcelable