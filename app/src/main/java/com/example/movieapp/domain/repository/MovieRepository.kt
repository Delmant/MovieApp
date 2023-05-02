package com.example.movieapp.domain.repository

import com.example.movieapp.domain.model.movie.Movie
import com.example.movieapp.domain.model.movie.Persons
import androidx.lifecycle.LiveData
import com.example.movieapp.domain.model.actor.Actor
import com.example.movieapp.domain.model.image.ImageList
import com.example.movieapp.domain.model.movie_list.MovieList
import com.example.movieapp.domain.model.review.ReviewList

interface MovieRepository {

     suspend fun getMovieById(id: Int): Movie

     suspend fun getImageByMovieId(id: Int): ImageList

     suspend fun getRandomMovie(): LiveData<Movie>

     suspend fun getMovie(): LiveData<Movie>

     suspend fun getMovieListByPage(): LiveData<List<Movie>>

     suspend fun getPersonById(id: Int): Actor

     suspend fun getReviewByMovieId(id: Int): ReviewList

     suspend fun loadData()
}