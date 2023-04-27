package com.example.movieapp.data.network.model.actor_dto

import com.example.movieapp.domain.model.actor.Fact

data class FactDto(
    val value: String?
) {
    companion object {
        fun toEntity(factDto: FactDto): Fact {
            return Fact(
                value = factDto.value ?: ""
            )
        }
    }
}