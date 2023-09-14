package com.example.movieapp.data.remote_data_source.model.review_dto

import com.example.movieapp.domain.model.review.Review
import com.google.gson.annotations.SerializedName

data class ReviewDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("movieId")
    val movieId: Int,
    @SerializedName("title")
    val title: String?,
    @SerializedName("type")
    val type: String?,
    @SerializedName("review")
    val review: String,
    @SerializedName("date")
    val date: String?,
    @SerializedName("author")
    val author: String,
    @SerializedName("authorId")
    val authorId: Int,
    @SerializedName("userRating")
    val userRating: Int?
) {
    companion object {
        fun toEntity(reviewDto: ReviewDto): Review {
            return Review(
                id = reviewDto.id,
                movieId = reviewDto.movieId,
                title = reviewDto.title ?: "",
                type = reviewDto.type ?: "",
                review = reviewDto.review,
                date = reviewDto.date ?: "",
                author = reviewDto.author,
                authorId = reviewDto.authorId,
                userRating = reviewDto.userRating ?: -1
            )
        }
    }
}