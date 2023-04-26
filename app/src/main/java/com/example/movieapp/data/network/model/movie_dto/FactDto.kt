package com.example.movieapp.data.network.model.movie_dto

import com.example.movieapp.domain.model.movie.Facts
import com.google.gson.annotations.SerializedName

data class FactDto(
    @SerializedName("value")
    val value: String?,
    @SerializedName("type")
    val type: String?,
    @SerializedName("spoiler")
    val spoiler: Boolean?
) {
    companion object {

        val empty = FactDto("", "",  false)
        fun toEntity(dto: FactDto): Facts {
            return Facts(
                spoiler = dto.spoiler ?: false,
                value = dto.value ?: "",
                type = dto.type ?: ""
            )
        }
    }
}