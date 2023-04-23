package com.example.movieapp.domain.usecases

import com.example.movieapp.domain.repository.MovieRepository
import javax.inject.Inject

class GetPersonByIdUseCase @Inject constructor(private val repository: MovieRepository) {

     suspend operator fun invoke() = repository.getPersonById()
}