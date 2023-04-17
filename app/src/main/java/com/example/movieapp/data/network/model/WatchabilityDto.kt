package com.example.movieapp.data.network.model

import com.example.movieapp.domain.model.Watchability
import com.google.gson.annotations.SerializedName

data class WatchabilityDto(
    @SerializedName("watchability")
    val watchability: Watchability
)