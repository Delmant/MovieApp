package com.example.movieapp.data.network.model

import com.example.movieapp.domain.model.ExternalId
import com.google.gson.annotations.SerializedName

data class ExternalIdDto(
    @SerializedName("kpHD")
    val kpHD: String?,
    @SerializedName("imdb")
    val imdb: String?,
    @SerializedName("tmdb")
    val tmdb: Int?,
) {
    companion object {

        val empty = ExternalIdDto("", "", -1)
        fun toEntity(dto: ExternalIdDto): ExternalId {
            return ExternalId(
                kpHD = dto.kpHD ?: "",
                imdb = dto.imdb ?: "",
                tmdb = dto.tmdb ?: -1
            )
        }
    }
}