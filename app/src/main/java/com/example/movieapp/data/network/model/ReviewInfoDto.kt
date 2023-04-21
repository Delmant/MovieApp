package com.example.movieapp.data.network.model

import com.example.movieapp.domain.model.ReviewInfo
import com.google.gson.annotations.SerializedName

data class ReviewInfoDto(
    @SerializedName("count")
    val count: Int,
    @SerializedName("positiveCount")
    val positiveCount: Int,
    @SerializedName("percentage")
    val percentage: String
) {
    companion object {
        fun toEntity(dto: ReviewInfoDto): ReviewInfo {
            return ReviewInfo(
                count = dto.count,
                positiveCount = dto.positiveCount,
                percentage = dto.percentage
            )
        }
    }
}