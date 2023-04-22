package com.example.movieapp.data.network.model

import com.example.movieapp.domain.model.Names
import com.google.gson.annotations.SerializedName

data class NameDto(
    @SerializedName("name")
    val name: String?,
    @SerializedName("language")
    val language: String?,
    @SerializedName("type")
    val type: String?
) {
    companion object {

        val empty = NameDto("", "", "")
        fun toEntity(dto: NameDto): Names {
            return Names(
                name = dto.name ?: "",
                language = dto.language ?: "",
                type = dto.type ?: ""
            )
        }
    }
}