package com.example.movieapp.data.remote_data_source.model.actor_dto

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