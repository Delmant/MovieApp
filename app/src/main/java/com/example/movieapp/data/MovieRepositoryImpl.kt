package com.example.movieapp.data


import com.example.movieapp.domain.model.Persons
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.example.movieapp.data.mapper.MovieMapper
import com.example.movieapp.data.network.ApiService
import com.example.movieapp.domain.model.*

import com.example.movieapp.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    val apiService: ApiService,
    val movieMapper: MovieMapper
): MovieRepository {

    override suspend fun getMovieById(id: Int): LiveData<Movie> {
        val movie = movieMapper.toEntity(apiService.getMovieById(id))
        val liveData = MutableLiveData<Movie>()
        liveData.value = movie
        return liveData
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

    override suspend fun getPersonById(): LiveData<Persons> {
        TODO("Not yet implemented")
    }

    override suspend fun loadData() {
        TODO("Not yet implemented")
    }
}