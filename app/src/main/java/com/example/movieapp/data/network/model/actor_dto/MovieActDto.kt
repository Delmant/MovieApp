package com.example.movieapp.data.network.model.actor_dto

import com.example.movieapp.domain.model.actor.MovieAct

data class MovieActDto(
    val description: String?,
    val general: Boolean?,
    val id: Int?,
    val name: String?,
    val rating: Double?
) {
    companion object {
        fun toEntity(movieActDto: MovieActDto): MovieAct {
            return MovieAct(
                description = movieActDto.description ?: "",
                general = movieActDto.general ?: false,
                id = movieActDto.id ?: -1,
                name = movieActDto.name ?: "",
                rating = movieActDto.rating ?: -1.0
            )
        }
    }
}