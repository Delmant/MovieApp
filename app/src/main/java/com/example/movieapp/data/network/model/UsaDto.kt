package com.example.movieapp.data.network.model

import com.example.movieapp.domain.model.Usa
import com.google.gson.annotations.SerializedName

data class UsaDto(
    @SerializedName("value")
    val value: Int,
    @SerializedName("currency")
    val currency: String
) {
    companion object {
        fun toEntity(dto: UsaDto): Usa {
            return Usa(
                value = dto.value,
                currency = dto.currency
            )
        }
    }
}