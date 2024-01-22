package com.example.movieapp.presentation.movie_detail_fragment

import com.example.movieapp.domain.model.image.ImageList
import com.example.movieapp.domain.model.movie.Movie
import com.example.movieapp.domain.model.review.ReviewList
import java.lang.Exception

sealed class MovieDetailState {
    object Initial: MovieDetailState()

    object IsLoading: MovieDetailState()

    data class IsError(val exception: Exception): MovieDetailState()

    data class Result(
        val movie: Movie?,
        val imageList: ImageList?,
        val review: ReviewList?
    ): MovieDetailState()
}