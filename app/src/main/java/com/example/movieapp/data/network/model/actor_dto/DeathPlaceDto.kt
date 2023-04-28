package com.example.movieapp.data.network.model.actor_dto

import com.example.movieapp.domain.model.actor.DeathPlace

data class DeathPlaceDto(
    val value: String
) {
    companion object {
        fun toEntity(deathPlaceDto: DeathPlaceDto): DeathPlace {
            return DeathPlace(
                value = deathPlaceDto.value
            )
        }
    }
}