package com.example.movieapp.data.remote_data_source.model.movie_dto

import com.example.movieapp.domain.model.movie.Videos
import com.google.gson.annotations.SerializedName

data class VideosDto(
    @SerializedName("trailers")
    val trailerDtos: List<TrailerDto?>,
    @SerializedName("teasers")
    val teaserDtos: List<TeaserDto?>
) {
    companion object {

        val empty = VideosDto(listOf(), listOf())
        fun toEntity(dto: VideosDto): Videos {
            val trailers = dto.trailerDtos.map {
                TrailerDto.toEntity(it ?: TrailerDto("", "", "", "", -1))
            }
            val teasers = dto.teaserDtos.map {
                TeaserDto.toEntity(it ?: TeaserDto("", "", "", "", -1))
            }
            return Videos(trailers = trailers, teasers = teasers)
        }
    }
}