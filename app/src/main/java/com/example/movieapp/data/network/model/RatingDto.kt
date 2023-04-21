package com.example.movieapp.data.network.model

import com.example.movieapp.domain.model.Rating
import com.google.gson.annotations.SerializedName

data class RatingDto(
    @SerializedName("kp")
    val kp: Double,
    @SerializedName("imdb")
    val imdb: Double,
    @SerializedName("tmdb")
    val tmdb: Double,
    @SerializedName("filmCritics")
    val filmCritics: Double,
    @SerializedName("russianFilmCritics")
    val russianFilmCritics: Double,
    @SerializedName("await")
    val await: Double
) {
    companion object {
        fun toEntity(dto: RatingDto): Rating {
            return Rating(
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