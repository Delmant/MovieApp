package com.example.movieapp.data.network.model.actor_dto

import com.google.gson.annotations.SerializedName

data class ActorDto(
    @SerializedName("age")
    val age: Int?,
    @SerializedName("birthPlace")
    val birthPlaceDto: List<BirthPlaceDto>?,
    @SerializedName("birthday")
    val birthday: String?,
    @SerializedName("countAwards")
    val countAwards: Int?,
    @SerializedName("death")
    val death: String?,
    @SerializedName("deathPlace")
    val deathPlace: List<DeathPlaceDto>?,
    @SerializedName("enName")
    val enName: String?,
    @SerializedName("facts")
    val factDtos: List<FactDto>?,
    @SerializedName("growth")
    val growth: Int?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("isParse")
    val isParse: Boolean?,
    @SerializedName("movies")
    val movies: List<MovieActDto>?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("photo")
    val photo: String?,
    @SerializedName("profession")
    val professionDto: List<ProfessionDto>?,
    @SerializedName("sex")
    val sex: String?,
//    @SerializedName("spouses")
//    val spouses: List<SpousesDto>?,
    @SerializedName("updatedAt")
    val updatedAt: String?
)