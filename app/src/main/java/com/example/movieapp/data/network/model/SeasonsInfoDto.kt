package com.example.movieapp.data.network.model

import com.example.movieapp.domain.model.SeasonsInfo
import com.google.gson.annotations.SerializedName

data class SeasonsInfoDto(
    @SerializedName("number")
    val number: Int,
    @SerializedName("episodesCount")
    val episodesCount: Int
) {
    companion object {
        fun toEntity(dto: SeasonsInfoDto): SeasonsInfo {
            return SeasonsInfo(
                number = dto.number,
                episodesCount = dto.episodesCount
            )
        }
    }
}