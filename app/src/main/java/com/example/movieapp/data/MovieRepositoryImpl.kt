package com.example.movieapp.data


import com.example.movieapp.domain.model.movie.Persons
import androidx.lifecycle.LiveData
import com.example.movieapp.data.mapper.MovieMapper
import com.example.movieapp.data.network.ApiService
import com.example.movieapp.domain.model.image.ImageList
import com.example.movieapp.domain.model.movie.Movie

import com.example.movieapp.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    val apiService: ApiService,
    val movieMapper: MovieMapper
): MovieRepository {



    override suspend fun getMovieById(id: Int): Movie {
        return movieMapper.toEntity(apiService.getMovieById(id))
    }

    override suspend fun getImageByMovieId(id: Int): ImageList {
        return movieMapper.imageListDtoToImageListEntity(apiService.getImageByMovieId(id, "frame"))
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