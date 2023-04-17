package com.example.movieapp.data.network.model

import com.example.movieapp.domain.model.Logo
import com.google.gson.annotations.SerializedName

data class LogoDto(
    @SerializedName("logo")
    val logo: Logo
)