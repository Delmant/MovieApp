package com.example.movieapp.data.network.model.movie_dto

import com.example.movieapp.domain.model.movie.Country
import com.google.gson.annotations.SerializedName

data class CountryDto(
    @SerializedName("name")
    val name: String?
) {
    companion object {

        val empty = CountryDto("")
        fun toEntity(dto: CountryDto): Country {
            return Country(
                name = dto.name ?: ""
            )
        }
    }
}