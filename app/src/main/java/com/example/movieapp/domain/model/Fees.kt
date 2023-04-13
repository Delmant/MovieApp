package com.example.movieapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Fees(
    val russia: Russia,
    val usa: Usa,
    val world: World
) : Parcelable