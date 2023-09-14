package com.example.movieapp.data.remote_data_source.model.movie_dto


import com.example.movieapp.domain.model.movie.Logo
import com.google.gson.annotations.SerializedName

data class LogoDto(
    @SerializedName("url")
    val url: String?
) {
    companion object {

        val empty = LogoDto("")
        fun toEntity(dto: LogoDto): Logo {
            return Logo(
                url = dto.url ?: ""
            )
        }
    }
}