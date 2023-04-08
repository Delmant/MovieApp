package com.example.movieapp.data

import Movie
import Person
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.movieapp.data.network.ApiService

import com.example.movieapp.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    val apiService: ApiService
): MovieRepository {

    override suspend fun getMovieById(id: Int): LiveData<Movie> {
//        return Transformations.map() {
//                it
//        }
        TODO()
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