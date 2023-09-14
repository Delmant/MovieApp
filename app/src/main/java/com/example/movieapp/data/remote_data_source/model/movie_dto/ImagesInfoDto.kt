package com.example.movieapp.data.remote_data_source.model.movie_dto

import com.example.movieapp.domain.model.movie.ImagesInfo
import com.google.gson.annotations.SerializedName

data class ImagesInfoDto(
    @SerializedName("postersCount")
    val postersCount: Int?,
    @SerializedName("backdropsCount")
    val backdropsCount: Int?,
    @SerializedName("framesCount")
    val framesCount: Int?,
) {
    companion object {

        val empty = ImagesInfoDto(-1, -1, -1)
        fun toEntity(dto: ImagesInfoDto): ImagesInfo {
            if (dto == null) return ImagesInfo(-1, -1, -1)
            return ImagesInfo(
                postersCount = dto.postersCount ?: 0,
                backdropsCount = dto.backdropsCount ?: 0,
                framesCount = dto.framesCount ?: 0
            )
        }
    }
}