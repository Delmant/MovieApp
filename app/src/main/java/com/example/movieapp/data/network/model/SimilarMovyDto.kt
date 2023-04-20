package com.example.movieapp.data.network.model

import com.example.movieapp.domain.model.SimilarMovies
import com.google.gson.annotations.SerializedName

data class SimilarMovyDto(
    @SerializedName("similarMovies")
    val similarMovies: SimilarMovies
) {
    companion object {
        fun toEntity(similarMovyDto: SimilarMovyDto): SimilarMovies {
            return similarMovyDto.similarMovies
        }
    }
}