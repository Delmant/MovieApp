package com.example.movieapp.data.network.model

import com.example.movieapp.domain.model.Russia
import com.google.gson.annotations.SerializedName

data class RussiaDto(
    @SerializedName("russia")
    val russia: Russia
)