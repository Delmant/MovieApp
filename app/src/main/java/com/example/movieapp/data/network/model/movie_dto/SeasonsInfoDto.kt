package com.example.movieapp.data.network.model.movie_dto

import com.example.movieapp.domain.model.movie.SeasonsInfo
import com.google.gson.annotations.SerializedName

data class SeasonsInfoDto(
    @SerializedName("number")
    val number: Int?,
    @SerializedName("episodesCount")
    val episodesCount: Int?
) {
    companion object {

        val empty = SeasonsInfoDto(-1, -1)
        fun toEntity(dto: SeasonsInfoDto): SeasonsInfo {
            return SeasonsInfo(
                number = dto.number ?: -1,
                episodesCount = dto.episodesCount ?: -1
            )
        }
    }
}