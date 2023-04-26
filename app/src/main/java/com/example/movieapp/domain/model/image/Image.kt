package com.example.movieapp.domain.model.image

data class Image(
    val height: Int,
    val id: String,
    val language: String,
    val movieId: Int,
    val previewUrl: String,
    val type: String,
    val url: String,
    val width: Int
) {
}