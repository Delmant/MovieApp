package com.example.movieapp.domain.usecases

import com.example.movieapp.domain.repository.MovieRepository
import javax.inject.Inject

class GetSearchResultUseCase @Inject constructor(private val movieRepository: MovieRepository) {

    suspend operator fun invoke(name: String) = movieRepository.getSearchResult(name)
}