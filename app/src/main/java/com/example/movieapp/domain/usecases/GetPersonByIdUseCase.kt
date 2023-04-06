package com.example.movieapp.domain.usecases

import com.example.movieapp.domain.repository.MovieRepository

class GetPersonByIdUseCase(private val repository: MovieRepository) {

    operator fun invoke() = repository.getPersonById()
}