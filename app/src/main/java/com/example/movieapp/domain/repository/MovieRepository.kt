package com.example.movieapp.domain.repository

import com.example.movieapp.domain.model.Movie
import com.example.movieapp.domain.model.Persons
import androidx.lifecycle.LiveData

interface MovieRepository {

     suspend fun getMovieById(id: Int): LiveData<Movie>

     suspend fun getRandomMovie(): LiveData<Movie>

     suspend fun getMovie(): LiveData<Movie>

     suspend fun getMovieListByPage(): LiveData<List<Movie>>

     suspend fun getPersonById(): LiveData<Persons>

     suspend fun loadData()
}