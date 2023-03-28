package com.example.movieapp.domain.usecases

import com.example.movieapp.domain.repository.MovieRepository

class GetMovieUseCase(private val movieRepository: MovieRepository) {
    operator fun invoke() = movieRepository.getMovie()
}