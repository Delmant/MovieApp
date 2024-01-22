package com.example.movieapp.presentation.review_detail_fragment

import com.example.movieapp.domain.model.review.ReviewList
import java.lang.Exception

sealed class ReviewState {
    object Initial: ReviewState()

    object IsLoading: ReviewState()

    data class IsError(
        val exception: Exception
    ): ReviewState()

    data class Result(
        val review: ReviewList
    ): ReviewState()
}
