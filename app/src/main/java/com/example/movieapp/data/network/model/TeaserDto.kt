package com.example.movieapp.data.network.model

import com.example.movieapp.domain.model.Teasers
import com.google.gson.annotations.SerializedName

data class TeaserDto(
    @SerializedName("url")
    val url: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("site")
    val site: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("size")
    val size: Int,
) {
    companion object {
        fun toEntity(dto: TeaserDto): Teasers {
            return Teasers(
                url = dto.url,
                name = dto.name,
                site = dto.site,
                type = dto.type,
                size = dto.size
            )
        }
    }
}