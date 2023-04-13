package com.example.movieapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SeasonsInfo(
    val episodesCount: Int,
    val number: Int
) : Parcelable