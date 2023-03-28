package com.example.movieapp.domain.repository

import Movie
import androidx.lifecycle.LiveData

interface MovieRepository {

    fun getMovieById(id: Int): LiveData<Movie>

    fun getRandomMovie(): LiveData<Movie>

    fun getMovie(): LiveData<Movie>

    fun getMovieList(): LiveData<List<Movie>>

    fun loadData()
}