package com.example.movieapp.data

import Movie
import Person
import androidx.lifecycle.LiveData
import com.example.movieapp.domain.repository.MovieRepository

class MovieRepositoryImpl(

): MovieRepository {

    override fun getMovieById(id: Int): LiveData<Movie> {
        TODO("Not yet implemented")
    }

    override fun getRandomMovie(): LiveData<Movie> {
        TODO("Not yet implemented")
    }

    override fun getMovie(): LiveData<Movie> {
        TODO("Not yet implemented")
    }

    override fun getMovieListByPage(): LiveData<List<Movie>> {
        TODO("Not yet implemented")
    }

    override fun getPersonById(): LiveData<Person> {
        TODO("Not yet implemented")
    }

    override fun loadData() {
        TODO("Not yet implemented")
    }
}