package com.example.movieapp.data.network.model

import com.example.movieapp.domain.model.ReviewInfo
import com.google.gson.annotations.SerializedName

data class ReviewInfoDto(
    @SerializedName("reviewInfo")
    val reviewInfo: ReviewInfo
) {
    companion object {
        fun toEntity(reviewInfoDto: ReviewInfoDto): ReviewInfo {
            return reviewInfoDto.reviewInfo
        }
    }
}