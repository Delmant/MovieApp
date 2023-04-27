package com.example.movieapp.data.network.model.actor_dto

import com.example.movieapp.domain.model.actor.Profession

data class ProfessionDto(
    val value: String?
) {
    companion object {
        fun toEntity(professionDto: ProfessionDto): Profession {
            return Profession(
                value = professionDto.value ?: ""
            )
        }
    }
}