package com.example.movieapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductionCompanies(
    val name: String,
    val previewUrl: String,
    val url: String
) : Parcelable