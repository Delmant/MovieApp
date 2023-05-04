package com.example.movieapp.data


import android.util.Log
import com.example.movieapp.domain.model.movie.Persons
import androidx.lifecycle.LiveData
import com.example.movieapp.data.mapper.MovieMapper
import com.example.movieapp.data.network.ApiService
import com.example.movieapp.domain.model.actor.Actor
import com.example.movieapp.domain.model.image.ImageList
import com.example.movieapp.domain.model.movie.Movie
import com.example.movieapp.domain.model.movie_list.MovieList
import com.example.movieapp.domain.model.review.ReviewList

import com.example.movieapp.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    val apiService: ApiService,
    val movieMapper: MovieMapper
) : MovieRepository {


    override suspend fun getMovieById(id: Int): Movie {
        return movieMapper.toEntity(apiService.getMovieById(id))
    }

    override suspend fun getSearchResult(name: String): MovieList {
        return movieMapper.movieListDtoToMovieList(apiService.getSearchResult(name))
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

    override suspend fun getPersonById(id: Int): Actor {
        return movieMapper.actorDtoToActorEntity(apiService.getPersonById(id))
    }

    override suspend fun getReviewByMovieId(id: Int): ReviewList {
        return movieMapper.reviewListDtoToReviewList(apiService.getReviewByMovieId(id))
    }

    override suspend fun loadData() {
        TODO("Not yet implemented")
    }
}