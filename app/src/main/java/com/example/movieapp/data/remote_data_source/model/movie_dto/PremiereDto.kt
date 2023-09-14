package com.example.movieapp.data.remote_data_source.model.movie_dto

import com.example.movieapp.domain.model.movie.Premiere
import com.google.gson.annotations.SerializedName

data class PremiereDto(
    @SerializedName("country")
    val country: String?,
    @SerializedName("world")
    val world: String?,
    @SerializedName("russia")
    val russia: String?,
    @SerializedName("digital")
    val digital: String?,
    @SerializedName("cinema")
    val cinema: String?,
    @SerializedName("bluray")
    val bluray: String?,
    @SerializedName("dvd")
    val dvd: String?
) {
    companion object {

        val empty = PremiereDto("", "", "", "", "", "", "")
        fun toEntity(dto: PremiereDto): Premiere {
            return Premiere(
                country = dto.country ?: "",
                world = dto.world ?: "",
                russia = dto.russia ?: "",
                digital = dto.digital ?: "",
                cinema = dto.cinema ?: "",
                bluray = dto.bluray ?: "",
                dvd = dto.dvd ?: ""
            )
        }
    }
}