package com.example.movieapp.data.network.model

import com.example.movieapp.domain.model.Persons
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
) {
    companion object {
        fun toEntity(dto: PersonDto): Persons {
            return Persons(
                id = dto.id,
                photo = dto.photo,
                name = dto.name,
                enName = dto.enName,
                description = dto.description,
                profession = dto.profession,
                enProfession = dto.enProfession
            )
        }
    }
}