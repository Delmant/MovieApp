package com.example.movieapp.data.network.model

import com.example.movieapp.domain.model.Facts
import com.google.gson.annotations.SerializedName

data class FactDto(
    @SerializedName("value")
    val value: String?,
    @SerializedName("type")
    val type: String?,
    @SerializedName("spoiler")
    val spoiler: Boolean?
) {
    companion object {
        fun toEntity(dto: FactDto): Facts {
            return Facts(
                spoiler = dto.spoiler ?: false,
                value = dto.value ?: "",
                type = dto.type ?: ""
            )
        }
    }
}