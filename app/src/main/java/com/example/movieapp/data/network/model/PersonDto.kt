package com.example.movieapp.data.network.model

import com.example.movieapp.domain.model.Persons
import com.google.gson.annotations.SerializedName

data class PersonDto(
    @SerializedName("persons")
    val persons: Persons
)