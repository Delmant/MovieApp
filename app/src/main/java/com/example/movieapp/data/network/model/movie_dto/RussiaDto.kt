package com.example.movieapp.data.network.model.movie_dto

import com.example.movieapp.domain.model.movie.Russia
import com.google.gson.annotations.SerializedName

data class RussiaDto(
    @SerializedName("value")
    val value: Int?,
    @SerializedName("currency")
    val currency: String?
) {
    companion object {

        val empty = RussiaDto(-1, "")
        fun toEntity(dto: RussiaDto): Russia {
            return Russia(
                value = dto.value ?: -1,
                currency = dto.currency ?: ""
            )
        }
    }
}