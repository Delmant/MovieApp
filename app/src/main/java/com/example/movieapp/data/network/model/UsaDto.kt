package com.example.movieapp.data.network.model

import com.example.movieapp.domain.model.Usa
import com.google.gson.annotations.SerializedName

data class UsaDto(
    @SerializedName("usa")
    val usa: Usa
) {
    companion object {
        fun toEntity(usaDto: UsaDto): Usa {
            return usaDto.usa
        }
    }
}