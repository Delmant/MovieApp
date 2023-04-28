package com.example.movieapp.data.network.model.actor_dto

import com.example.movieapp.domain.model.actor.ActorFact

data class FactDto(
    val value: String?
) {
    companion object {
        fun toEntity(factDto: FactDto): ActorFact {
            return ActorFact(
                value = factDto.value ?: ""
            )
        }
    }
}