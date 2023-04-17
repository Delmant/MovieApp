package com.example.movieapp.data.network.model

import com.example.movieapp.domain.model.Facts
import com.google.gson.annotations.SerializedName

data class FactDto(
    @SerializedName("facts")
    val facts: Facts

)