package com.example.movieapp.domain.usecases

import com.example.movieapp.domain.repository.MovieRepository
import javax.inject.Inject

class GetMovieByIdUseCase @Inject constructor(private val movieRepository: MovieRepository) {

    suspend operator fun invoke(id: Int) = movieRepository.getMovieById(id)
}