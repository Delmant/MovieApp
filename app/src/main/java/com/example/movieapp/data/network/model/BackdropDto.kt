package com.example.movieapp.data.network.model

import com.example.movieapp.domain.model.Backdrop
import com.google.gson.annotations.SerializedName

data class BackdropDto(
    @SerializedName("backdrop")
    val backDrop: Backdrop
)