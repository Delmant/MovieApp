package com.example.movieapp.data.network.model

import com.example.movieapp.domain.model.ImagesInfo
import com.google.gson.annotations.SerializedName

data class ImagesInfoDto(
    @SerializedName("imagesInfo")
    val imagesInfo: ImagesInfo
) {
    companion object {
        fun toEntity(imagesInfoDto: ImagesInfoDto): ImagesInfo {
            return imagesInfoDto.imagesInfo
        }
    }
}