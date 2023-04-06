package com.example.movieapp.domain.usecases

import com.example.movieapp.domain.repository.MovieRepository

class LoadDataUseCase(private val movieRepository: MovieRepository) {
    suspend operator fun invoke() = movieRepository.loadData()
}