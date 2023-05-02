package com.example.movieapp.domain.model.review

import com.google.gson.annotations.SerializedName

data class Review(
    val id: Int,
    val movieId: Int,
    val title: String,
    val type: String,
    val review: String,
    val date: String,
    val author: String,
    val authorId: Int,
    val userRating: Int
)