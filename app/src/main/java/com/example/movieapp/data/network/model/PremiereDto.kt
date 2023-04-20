package com.example.movieapp.data.network.model

import com.example.movieapp.domain.model.Premiere
import com.google.gson.annotations.SerializedName

data class PremiereDto(
    @SerializedName("premiere")
    val premiere: Premiere
) {
    companion object {
        fun toEntity(premiereDto: PremiereDto): Premiere {
            return premiereDto.premiere
        }
    }
}