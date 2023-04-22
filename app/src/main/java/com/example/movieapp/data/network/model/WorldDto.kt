package com.example.movieapp.data.network.model

import com.example.movieapp.domain.model.World
import com.google.gson.annotations.SerializedName

data class WorldDto(
    @SerializedName("value")
    val value: Int?,
    @SerializedName("currency")
    val currency: String?,
) {
    companion object {

        val empty = WorldDto(-1, "")
        fun toEntity(dto: WorldDto): World {
            return World(
                value = dto.value ?: -1,
                currency = dto.currency ?: ""
            )
        }
    }
}