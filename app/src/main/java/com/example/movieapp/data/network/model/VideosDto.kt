package com.example.movieapp.data.network.model

import com.example.movieapp.domain.model.Teasers
import com.example.movieapp.domain.model.Trailers
import com.example.movieapp.domain.model.Videos
import com.google.gson.annotations.SerializedName

data class VideosDto(
    @SerializedName("trailers")
    val trailerDtos: List<TrailerDto>,
    @SerializedName("teasers")
    val teaserDtos: List<TeaserDto>
) {
    companion object {
        fun toEntity(dto: VideosDto): Videos {
            val trailers = dto.trailerDtos.map {
                TrailerDto.toEntity(it)
            }
            val teasers = dto.teaserDtos.map {
                TeaserDto.toEntity(it)
            }
            return Videos(trailers = trailers, teasers = teasers)
        }
    }
}