package com.example.movieapp.data.network.model

import com.example.movieapp.domain.model.Items
import com.google.gson.annotations.SerializedName

data class ItemDto(
    @SerializedName("name")
    val name: String?,
    @SerializedName("logo")
    val logoDto: LogoDto?,
    @SerializedName("url")
    val url: String?
) {
    companion object {
        fun toEntity(dto: ItemDto): Items {
            return Items(
                name = dto.name ?: "",
                logo = LogoDto.toEntity(dto.logoDto ?: LogoDto("")),
                url = dto.url ?: ""
            )
        }
    }
}