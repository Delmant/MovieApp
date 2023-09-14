package com.example.movieapp.data.remote_data_source.model.actor_dto

import com.example.movieapp.domain.model.actor.MovieAct
import com.google.gson.annotations.SerializedName

data class MovieActDto(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("alternativeName")
    val alternativeName: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("genera;")
    val general: Boolean?,
    @SerializedName("rating")
    val rating: Double?
) {
    companion object {
        fun toEntity(movieActDto: MovieActDto): MovieAct {
            return MovieAct(
                description = movieActDto.description ?: "",
                general = movieActDto.general ?: false,
                id = movieActDto.id ?: -1,
                name = movieActDto.name ?: "",
                rating = movieActDto.rating ?: -1.0,
                alternativeName = movieActDto.alternativeName ?: ""
            )
        }
    }
}