package com.example.movieapp.data.remote_data_source.model.movie_dto

import com.example.movieapp.domain.model.movie.ExternalId
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