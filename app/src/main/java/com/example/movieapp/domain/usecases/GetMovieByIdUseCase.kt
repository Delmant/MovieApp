package com.example.movieapp.domain.usecases

import com.example.movieapp.domain.repository.MovieRepository

class GetMovieByIdUseCase(private val movieRepository: MovieRepository) {

    suspend operator fun invoke(id: Int) = movieRepository.getMovieById(id)
}