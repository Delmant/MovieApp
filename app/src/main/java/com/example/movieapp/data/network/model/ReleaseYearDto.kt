package com.example.movieapp.data.network.model

import com.google.gson.annotations.SerializedName

data class ReleaseYearDto(
    @SerializedName("start")
    val start: Int,
    @SerializedName("end")
    val end: Int
)