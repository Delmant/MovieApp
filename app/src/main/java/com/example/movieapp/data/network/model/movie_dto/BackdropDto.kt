package com.example.movieapp.data.network.model.movie_dto

import com.example.movieapp.domain.model.movie.Backdrop
import com.google.gson.annotations.SerializedName

data class BackdropDto(
    @SerializedName("url")
    val url: String?,
    @SerializedName("previewUrl")
    val previewUrl: String?
) {
    companion object {

        val empty = BackdropDto("", "")

        fun toEntity(dto: BackdropDto): Backdrop {
            return Backdrop(
                url = dto.url ?: "",
                previewUrl = dto.previewUrl ?: ""
            )
        }
    }
}