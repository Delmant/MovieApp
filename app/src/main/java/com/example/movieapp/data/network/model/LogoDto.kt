package com.example.movieapp.data.network.model


import com.example.movieapp.domain.model.Logo
import com.google.gson.annotations.SerializedName

data class LogoDto(
    @SerializedName("url")
    val url: String?
) {
    companion object {
        fun toEntity(dto: LogoDto): Logo {
            return Logo(
                url = dto.url ?: ""
            )
        }
    }
}