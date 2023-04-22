package com.example.movieapp.data.network.model

import com.example.movieapp.domain.model.Poster
import com.google.gson.annotations.SerializedName

data class PosterDto(
    @SerializedName("url")
    val url: String?,
    @SerializedName("previewUrl")
    val previewUrl: String?
) {
    companion object {

        val empty = PosterDto("", "")
        fun toEntity(dto: PosterDto): Poster {
            return Poster(
                url = dto.url ?: "",
                previewUrl = dto.previewUrl ?: ""
            )
        }
    }
}