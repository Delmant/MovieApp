package com.example.movieapp.data.network.model

import com.example.movieapp.domain.model.Country
import com.google.gson.annotations.SerializedName

data class CountryDto(
    @SerializedName("name")
    val name: String?
) {
    companion object {
        fun toEntity(dto: CountryDto): Country {
            return Country(
                name = dto.name ?: ""
            )
        }
    }
}