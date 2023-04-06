package com.example.movieapp.domain.usecases

import com.example.movieapp.domain.repository.MovieRepository

class GetPersonByIdUseCase(private val repository: MovieRepository) {

    suspend operator fun invoke() = repository.getPersonById()
}