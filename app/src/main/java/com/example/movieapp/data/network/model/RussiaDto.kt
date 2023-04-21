package com.example.movieapp.data.network.model

import com.example.movieapp.domain.model.Russia
import com.google.gson.annotations.SerializedName

data class RussiaDto(
    @SerializedName("value")
    val value: Int,
    @SerializedName("currency")
    val currency: String
) {
    companion object {
        fun toEntity(dto: RussiaDto): Russia {
            return Russia(
                value = dto.value,
                currency = dto.currency
            )
        }
    }
}