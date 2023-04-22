package com.example.movieapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Persons(
    val description: String,
    val enName: String,
    val enProfession: String,
    val id: Int,
    val name: String,
    val photo: String,
    val profession: String
) : Parcelable