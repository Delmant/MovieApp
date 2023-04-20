package com.example.movieapp.data.network.model

import com.google.gson.annotations.SerializedName

data class SeasonsInfoDto(
    @SerializedName("number")
    val number: Int,
    @SerializedName("episodesCount")
    val episodesCount: Int
)