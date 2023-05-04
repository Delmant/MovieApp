package com.example.movieapp.presentation.actor_detail_fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.R
import com.example.movieapp.data.mapper.MovieMapper
import com.example.movieapp.domain.model.actor.Actor
import com.example.movieapp.domain.model.actor.ActorFact
import com.example.movieapp.domain.model.actor.Profession
import com.example.movieapp.domain.model.movie.Facts
import com.example.movieapp.domain.usecases.GetMovieByIdUseCase
import com.example.movieapp.domain.usecases.GetPersonByIdUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class ActorDetailViewModel @Inject constructor(
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

    fun parseActorDateOfBirth(date: String): String {
        if (date.isEmpty()) return ""
        val splitString = date.split("-")
        val year = splitString[0]
        val month = Month.getMonth(splitString[1])
        val day = if (splitString[1].contains("0"))
            splitString[1].replace("0", "")
        else splitString[1]
        return "$day $month $year"
    }

    fun convertFactsList(list: List<ActorFact>): List<Facts> {
        return mapper.actorFactListToFactsList(list)
    }

    fun parseName(name: String): String {
        if (name.isEmpty()) return name
        return name.replace(" ", "\n")
    }

    fun parseActorProfession(list: List<Profession>): String {
        var actorProfession = ""
        list.forEachIndexed { index, prof ->
            actorProfession += if (index == list.size - 1)
                prof.value
            else {
                "${prof.value}, "
            }
        }
        return actorProfession
    }

    enum class Month(val monthNumber: String) {
        Января("01"),
        Февраля("02"),
        Марта("03"),
        Апреля("04"),
        Мая("05"),
        Июня("06"),
        Июля("07"),
        Августа("08"),
        Сентября("09"),
        Октября("10"),
        Ноября("11"),
        Декабря("12");

        companion object {
            fun getMonth(monthNumber: String): Month {
                return values().find { it.monthNumber == monthNumber }
                    ?: throw IllegalArgumentException("Invalid month number: $monthNumber")

            }
        }
    }
}