package com.example.movieapp.data.remote_data_source.model.movie_dto

import com.example.movieapp.domain.model.movie.ReviewInfo
import com.google.gson.annotations.SerializedName

data class ReviewInfoDto(
    @SerializedName("count")
    val count: Int?,
    @SerializedName("positiveCount")
    val positiveCount: Int?,
    @SerializedName("percentage")
    val percentage: String?
) {
    companion object {

        val empty = ReviewInfoDto(-1, -1, "")
        fun toEntity(dto: ReviewInfoDto): ReviewInfo {
            return ReviewInfo(
                count = dto.count ?: -1,
                positiveCount = dto.positiveCount ?: -1,
                percentage = dto.percentage ?: ""
            )
        }
    }
}