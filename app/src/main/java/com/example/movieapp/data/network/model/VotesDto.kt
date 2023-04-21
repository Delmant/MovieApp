package com.example.movieapp.data.network.model

import com.example.movieapp.domain.model.Votes
import com.google.gson.annotations.SerializedName

data class VotesDto(
    @SerializedName("kp")
    val kp: String,
    @SerializedName("imdb")
    val imdb: String,
    @SerializedName("tmdb")
    val tmdb: Int,
    @SerializedName("filmCritics")
    val filmCritics: Int,
    @SerializedName("russianFilmCritics")
    val russianFilmCritics: Int,
    @SerializedName("await")
    val await: Int,
) {
    companion object {
        fun toEntity(dto: VotesDto): Votes {
            return Votes(
                kp = dto.kp,
                imdb = dto.imdb,
                tmdb = dto.tmdb,
                filmCritics = dto.filmCritics,
                russianFilmCritics = dto.russianFilmCritics,
                await = dto.await
            )
        }
    }
}