package com.example.movieapp.domain.repository

import com.example.movieapp.domain.model.Movie
import com.example.movieapp.domain.model.Person
import androidx.lifecycle.LiveData

interface MovieRepository {

     fun getMovieById(id: Int): LiveData<Movie>

     fun getRandomMovie(): LiveData<Movie>

     fun getMovie(): LiveData<Movie>

     fun getMovieListByPage(): LiveData<List<Movie>>

     fun getPersonById(): LiveData<Person>

     fun loadData()
}