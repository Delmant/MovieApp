package com.example.movieapp.data.network.model

import com.example.movieapp.domain.model.Trailers
import com.google.gson.annotations.SerializedName

data class TrailerDto(
    @SerializedName("url")
    val url: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("site")
    val site: String?,
    @SerializedName("type")
    val type: String?,
    @SerializedName("size")
    val size: Int?
) {
    companion object {

        val empty = TrailerDto("", "", "", "", -1)
        fun toEntity(dto: TrailerDto): Trailers {
            return Trailers(
                url = dto.url ?: "",
                name = dto.name ?: "",
                size = dto.size ?: -1,
                type = dto.type ?: "",
                site = dto.site ?: ""
            )
        }
    }
}