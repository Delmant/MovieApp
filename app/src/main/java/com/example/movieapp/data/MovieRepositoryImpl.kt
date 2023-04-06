package com.example.movieapp.data

import Movie
import Person
import androidx.lifecycle.LiveData

import com.example.movieapp.domain.repository.MovieRepository

class MovieRepositoryImpl(

): MovieRepository {

    override suspend fun getMovieById(id: Int): LiveData<Movie> {
        TODO("Not yet implemented")
    }

    override suspend fun getRandomMovie(): LiveData<Movie> {
        TODO("Not yet implemented")
    }

    override suspend fun getMovie(): LiveData<Movie> {
        TODO("Not yet implemented")
    }

    override suspend fun getMovieListByPage(): LiveData<List<Movie>> {
        TODO("Not yet implemented")
    }

    override suspend fun getPersonById(): LiveData<Person> {
        TODO("Not yet implemented")
    }

    override suspend fun loadData() {
        TODO("Not yet implemented")
    }
}