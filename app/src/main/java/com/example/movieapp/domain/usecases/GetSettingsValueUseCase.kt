package com.example.movieapp.domain.usecases

import com.example.movieapp.domain.repository.MovieRepository
import javax.inject.Inject

class GetSettingsValueUseCase @Inject constructor(val repository: MovieRepository) {
    suspend operator fun invoke(value: String) = repository.getSettingsValue(value)
}