package com.example.movieapp.data.network.model.movie_dto


import com.example.movieapp.domain.model.movie.Genres
import com.google.gson.annotations.SerializedName

data class GenreDto(
    @SerializedName("name")
    val name: String?
) {
    companion object {

        val empty = GenreDto("")
        fun toEntity(dto: GenreDto): Genres {
            return Genres(
                name = dto.name ?: ""
            )
        }
    }
}