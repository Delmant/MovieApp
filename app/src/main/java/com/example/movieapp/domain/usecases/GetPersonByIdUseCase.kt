package com.example.movieapp.domain.usecases

import com.example.movieapp.domain.model.actor.Actor
import com.example.movieapp.domain.reaction.Reaction
import com.example.movieapp.domain.repository.MovieRepository
import javax.inject.Inject

class GetPersonByIdUseCase @Inject constructor(private val repository: MovieRepository) {

     suspend operator fun invoke(personId: Int): Reaction<Actor> = repository.getPersonById(personId)
}