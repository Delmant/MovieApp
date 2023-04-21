package com.example.movieapp.data.network.model

import com.example.movieapp.domain.model.ImagesInfo
import com.google.gson.annotations.SerializedName

data class ImagesInfoDto(
    @SerializedName("postersCount")
    val postersCount: Int?,
    @SerializedName("backdropsCount")
    val backdropsCount: Int?,
    @SerializedName("framesCount")
    val framesCount: Int?
) {
    companion object {
        fun toEntity(dto: ImagesInfoDto): ImagesInfo {
            if(dto == null) return ImagesInfo(-1,-1,-1)
            return ImagesInfo(
                postersCount = dto.postersCount ?: 0,
                backdropsCount = dto.backdropsCount ?: 0,
                framesCount = dto.framesCount ?: 0
            )
        }
    }
}