package com.example.movieapp.data.network.model.image_dto

import com.example.movieapp.domain.model.image.Image

data class ImageDto(
    val height: Int?,
    val id: String,
    val language: String?,
    val movieId: Int,
    val previewUrl: String,
    val type: String,
    val url: String,
    val width: Int?
) {

    companion object {

        fun toEntity(imageDto: ImageDto): Image {
            return Image(
                height = imageDto.height ?: -1,
                id = imageDto.id,
                language = imageDto.language ?: "",
                movieId = imageDto.movieId,
                previewUrl = imageDto.previewUrl,
                type = imageDto.type,
                url = imageDto.url,
                width = imageDto.width ?: -1
            )
        }
    }
}