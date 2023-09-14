package com.example.movieapp.data.remote_data_source.model.movie_dto

import com.example.movieapp.domain.model.movie.Teasers
import com.google.gson.annotations.SerializedName

data class TeaserDto(
    @SerializedName("url")
    val url: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("site")
    val site: String?,
    @SerializedName("type")
    val type: String?,
    @SerializedName("size")
    val size: Int?,
) {
    companion object {

        val empty = TeaserDto("", "", "", "", -1)
        fun toEntity(dto: TeaserDto): Teasers {
            return Teasers(
                url = dto.url ?: "",
                name = dto.name ?: "",
                site = dto.site ?: "",
                type = dto.type ?: "",
                size = dto.size ?: -1
            )
        }
    }
}