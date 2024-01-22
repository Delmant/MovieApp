package com.example.movieapp.domain.usecases

import com.example.movieapp.domain.model.movie.Movie
import com.example.movieapp.domain.reaction.Reaction
import com.example.movieapp.domain.repository.MovieRepository
import javax.inject.Inject

class GetMovieByIdUseCase @Inject constructor(private val movieRepository: MovieRepository) {

     suspend operator fun invoke(id: Int): Reaction<Movie> = movieRepository.getMovieById(id)
}