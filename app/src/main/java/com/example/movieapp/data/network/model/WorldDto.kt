package com.example.movieapp.data.network.model

import com.example.movieapp.domain.model.World
import com.google.gson.annotations.SerializedName

data class WorldDto(
    @SerializedName("world")
    val world: World
)