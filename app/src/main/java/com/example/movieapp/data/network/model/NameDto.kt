package com.example.movieapp.data.network.model

import com.example.movieapp.domain.model.Names
import com.google.gson.annotations.SerializedName

data class NameDto(
    @SerializedName("names")
    val names: Names
)