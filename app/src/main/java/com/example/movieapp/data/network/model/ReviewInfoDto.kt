package com.example.movieapp.data.network.model

import com.google.gson.annotations.SerializedName

data class ReviewInfoDto(
    @SerializedName("count")
    val count: Int,
    @SerializedName("positiveCount")
    val positiveCount: Int,
    @SerializedName("percentage")
    val percentage: String
)