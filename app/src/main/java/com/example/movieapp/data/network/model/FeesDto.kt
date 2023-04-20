package com.example.movieapp.data.network.model

import com.google.gson.annotations.SerializedName

data class FeesDto(
    @SerializedName("world")
    val worldDto: WorldDto,
    @SerializedName("russia")
    val russiaDto: RussiaDto,
    @SerializedName("usa")
    val usaDto: UsaDto

)