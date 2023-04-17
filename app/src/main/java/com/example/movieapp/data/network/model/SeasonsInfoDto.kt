package com.example.movieapp.data.network.model

import com.example.movieapp.domain.model.SeasonsInfo
import com.google.gson.annotations.SerializedName

data class SeasonsInfoDto(
    @SerializedName("seasonsInfo")
    val seasonsInfo: SeasonsInfo
)