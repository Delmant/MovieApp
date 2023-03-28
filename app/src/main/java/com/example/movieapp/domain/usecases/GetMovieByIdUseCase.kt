package com.example.movieapp.domain.usecases

import com.example.movieapp.domain.MovieRepository

class GetMovieByIdUseCase(private val movieRepository: MovieRepository) {

    operator fun invoke(id: Int) = movieRepository.getMovieById(id)
}