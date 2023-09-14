package com.example.movieapp.data.remote_data_source.model.actor_dto

import com.example.movieapp.domain.model.actor.BirthPlace

data class BirthPlaceDto(
    val value: String?
) {
    companion object {
        fun toEntity(birthPlaceDto: BirthPlaceDto): BirthPlace {
            return BirthPlace(
                value = birthPlaceDto.value ?: ""
            )
        }
    }
}