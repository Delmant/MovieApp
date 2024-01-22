package com.example.movieapp.domain.usecases

import com.example.movieapp.domain.model.review.ReviewList
import com.example.movieapp.domain.reaction.Reaction
import com.example.movieapp.domain.repository.MovieRepository
import javax.inject.Inject

class GetReviewByMovieIdUseCase @Inject constructor(private val movieRepository: MovieRepository) {
    suspend operator fun invoke(id: Int, page: Int): Reaction<ReviewList> = movieRepository.getReviewByMovieId(id, page)
}