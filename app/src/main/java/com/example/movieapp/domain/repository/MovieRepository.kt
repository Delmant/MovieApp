package com.example.movieapp.domain.repository

import com.example.movieapp.domain.model.movie.Movie
import com.example.movieapp.domain.model.movie.Persons
import androidx.lifecycle.LiveData
import com.example.movieapp.domain.model.image.ImageList

interface MovieRepository {

     suspend fun getMovieById(id: Int): Movie

     suspend fun getImageByMovieId(id: Int): ImageList

     suspend fun getRandomMovie(): LiveData<Movie>

     suspend fun getMovie(): LiveData<Movie>

     suspend fun getMovieListByPage(): LiveData<List<Movie>>

     suspend fun getPersonById(): LiveData<Persons>

     suspend fun loadData()
}