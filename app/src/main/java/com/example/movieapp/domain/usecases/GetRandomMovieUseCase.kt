package com.example.movieapp.domain.usecases

import com.example.movieapp.domain.repository.MovieRepository
import javax.inject.Inject

class GetRandomMovieUseCase @Inject constructor(private val movieRepository: MovieRepository) {
     suspend operator fun invoke() = movieRepository.getRandomMovie()
}