package com.example.movieapp.data.network.model.movie_dto

import com.example.movieapp.domain.model.movie.Votes
import com.google.gson.annotations.SerializedName

data class VotesDto(
    @SerializedName("kp")
    val kp: String?,
    @SerializedName("imdb")
    val imdb: String?,
    @SerializedName("tmdb")
    val tmdb: Int?,
    @SerializedName("filmCritics")
    val filmCritics: Int?,
    @SerializedName("russianFilmCritics")
    val russianFilmCritics: Int?,
    @SerializedName("await")
    val await: Int?,
) {
    companion object {

        val empty = VotesDto("", "", -1, -1, -1, -1)
        fun toEntity(dto: VotesDto): Votes {
            return Votes(
                kp = dto.kp ?: "",
                imdb = dto.imdb ?: "",
                tmdb = dto.tmdb ?: -1,
                filmCritics = dto.filmCritics ?: -1,
                russianFilmCritics = dto.russianFilmCritics ?: -1,
                await = dto.await ?: -1
            )
        }
    }
}