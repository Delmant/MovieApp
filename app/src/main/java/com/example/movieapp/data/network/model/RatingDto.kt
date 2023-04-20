package com.example.movieapp.data.network.model

import com.example.movieapp.domain.model.Rating
import com.google.gson.annotations.SerializedName

data class RatingDto(
    @SerializedName("rating")
    val rating: Rating
) {
    companion object {
        fun toEntity(ratingDto: RatingDto): Rating {
            return ratingDto.rating
        }
    }
}