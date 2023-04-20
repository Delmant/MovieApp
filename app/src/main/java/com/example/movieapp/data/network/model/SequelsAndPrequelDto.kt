package com.example.movieapp.data.network.model

import com.google.gson.annotations.SerializedName

data class SequelsAndPrequelDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("enName")
    val enName: String,
    @SerializedName("alternativeName")
    val alternativeName: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("poster")
    val posterDto: PosterDto
)