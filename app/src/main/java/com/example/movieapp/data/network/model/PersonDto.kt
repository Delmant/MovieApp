package com.example.movieapp.data.network.model

import com.google.gson.annotations.SerializedName

data class PersonDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("photo")
    val photo: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("enName")
    val enName: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("profession")
    val profession: String,
    @SerializedName("enProfession")
    val enProfession: String,
)