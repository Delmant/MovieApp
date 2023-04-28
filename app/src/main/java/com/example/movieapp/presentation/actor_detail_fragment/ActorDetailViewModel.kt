package com.example.movieapp.presentation.actor_detail_fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.data.mapper.MovieMapper
import com.example.movieapp.domain.model.actor.Actor
import com.example.movieapp.domain.model.actor.ActorFact
import com.example.movieapp.domain.model.movie.Facts
import com.example.movieapp.domain.model.movie.Movie
import com.example.movieapp.domain.model.movie.SimilarMovies
import com.example.movieapp.domain.usecases.GetMovieByIdUseCase
import com.example.movieapp.domain.usecases.GetPersonByIdUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class ActorDetailViewModel @Inject constructor (
    private val getPersonByIdUseCase: GetPersonByIdUseCase,
    private val mapper: MovieMapper,
    private val getMovieByIdUseCase: GetMovieByIdUseCase
) : ViewModel() {

    private val _personLiveData = MutableLiveData<Actor>()
    val personLiveData: LiveData<Actor> = _personLiveData

    fun getPerson(id: Int) {
        viewModelScope.launch {
            val person = getPersonByIdUseCase.invoke(id)
            _personLiveData.value = person
        }
    }

    fun convertFactsList(list: List<ActorFact>): List<Facts> {
        return mapper.actorFactListToFactsList(list)
    }

    fun parseName(name: String): String {
        if (name.isEmpty()) return name
        return name.replace(" ", "\n")
    }

    fun movieListToSequelsList(list: List<Movie>): List<SimilarMovies> {
        return list.map {
            SimilarMovies(
                alternativeName = it.alternativeName,
                enName = it.enName,
                id = it.id,
                name = it.name,
                poster = it.poster,
                type = it.type
            )
        }
    }
}