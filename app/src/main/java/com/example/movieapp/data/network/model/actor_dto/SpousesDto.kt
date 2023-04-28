package com.example.movieapp.data.network.model.actor_dto

import com.example.movieapp.domain.model.actor.Spouses

data class SpousesDto(
    val id: Int,
    val name: String,
    val divorced: Boolean,
    val divorcedReason: String?,
    val sex: String,
    val children: Int,
    val relation: String
) {
    val empty = Spouses(
        -1,
        "",
        false,
        "",
        "",
        -1,
        ""
    )

    companion object {
        fun toEntity(spousesDto: SpousesDto): Spouses {
            return Spouses(
                id = spousesDto.id,
                name = spousesDto.name,
                divorced = spousesDto.divorced,
                sex = spousesDto.sex,
                children = spousesDto.children,
                relation = spousesDto.relation,
                divorcedReason = spousesDto.divorcedReason
            )
        }
    }
}