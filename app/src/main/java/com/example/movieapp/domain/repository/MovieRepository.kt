package com.example.movieapp.domain.repository

import Movie
import Person
import androidx.lifecycle.LiveData

interface MovieRepository {

    suspend fun getMovieById(id: Int): LiveData<Movie>

    suspend fun getRandomMovie(): LiveData<Movie>

    suspend fun getMovie(): LiveData<Movie>

    suspend fun getMovieListByPage(): LiveData<List<Movie>>

    suspend fun getPersonById(): LiveData<Person>

    suspend fun loadData()
}