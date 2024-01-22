package com.example.movieapp.domain.usecases

import com.example.movieapp.domain.repository.MovieRepository
import javax.inject.Inject

class SaveSharedPrefSearchSettingsUseCase @Inject constructor(private val movieRepository: MovieRepository) {
    operator fun invoke(type: String, gson: String) =
        movieRepository.saveSharedPrefSearchSettings(type, gson)
}