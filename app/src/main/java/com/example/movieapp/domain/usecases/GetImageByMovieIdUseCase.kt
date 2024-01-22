package com.example.movieapp.domain.usecases

import com.example.movieapp.domain.model.image.ImageList
import com.example.movieapp.domain.reaction.Reaction
import com.example.movieapp.domain.repository.MovieRepository
import javax.inject.Inject

class GetImageByMovieIdUseCase @Inject constructor(private val movieRepository: MovieRepository) {
    suspend operator fun invoke(movieId: Int): Reaction<ImageList> =
        movieRepository.getImageByMovieId(movieId)
}