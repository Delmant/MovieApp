package com.example.movieapp.domain.model.movie

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SequelsAndPrequels(
    val alternativeName: String,
    val enName: String,
    val id: Int,
    val name: String,
    val poster: Poster,
    val type: String
) : Parcelable