package com.example.movieapp.data.network.model

import com.example.movieapp.domain.model.Rating
import com.google.gson.annotations.SerializedName

data class RatingDto(
    @SerializedName("kp")
    val kp: Double?,
    @SerializedName("imdb")
    val imdb: Double?,
    @SerializedName("tmdb")
    val tmdb: Double?,
    @SerializedName("filmCritics")
    val filmCritics: Double?,
    @SerializedName("russianFilmCritics")
    val russianFilmCritics: Double?,
    @SerializedName("await")
    val await: Double?
) {
    companion object {

        val empty = RatingDto(-1.0, -1.0, -1.0, -1.0, -1.0, -1.0)
        fun toEntity(dto: RatingDto): Rating {
            return Rating(
                kp = dto.kp ?: -1.0,
                imdb = dto.imdb ?: -1.0,
                tmdb = dto.tmdb ?: -1.0,
                filmCritics = dto.filmCritics?: -1.0,
                russianFilmCritics = dto.russianFilmCritics ?: -1.0,
                await = dto.await ?: -1.0
            )
        }
    }
}