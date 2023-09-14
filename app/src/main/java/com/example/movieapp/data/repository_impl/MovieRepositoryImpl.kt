package com.example.movieapp.data.repository_impl


import androidx.lifecycle.LiveData
import com.example.movieapp.data.mapper.MovieMapper
import com.example.movieapp.data.remote_data_source.ApiService
import com.example.movieapp.data.remote_data_source.MovieRemoteDataSource
import com.example.movieapp.domain.model.actor.Actor
import com.example.movieapp.domain.model.image.ImageList
import com.example.movieapp.domain.model.movie.Movie
import com.example.movieapp.domain.model.movie_list.MovieList
import com.example.movieapp.domain.model.review.ReviewList
import com.example.movieapp.domain.model.search_settings.SettingsValue

import com.example.movieapp.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val movieMapper: MovieMapper,
    private val movieRemoteDataSource: MovieRemoteDataSource
) : MovieRepository {


    override suspend fun getMovieById(id: Int): Movie {
        return movieMapper.toEntity(movieRemoteDataSource.getMovieById(id))
    }

    override suspend fun getSearchResult(name: String): MovieList {
        return movieMapper.movieListDtoToMovieList(apiService.getSearchResult(name))
    }

    override suspend fun getImageByMovieId(id: Int): ImageList {
        return movieMapper.imageListDtoToImageListEntity(movieRemoteDataSource.getImageByMovieId(id))
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

    override suspend fun getReviewByMovieId(id: Int, page: Int): ReviewList {
        return movieMapper.reviewListDtoToReviewList(apiService.getReviewByMovieId(id, page))
    }

    override suspend fun loadData() {
        TODO("Not yet implemented")
    }

    override suspend fun getSettingsValue(value: String): List<SettingsValue> {
        return movieMapper.settingsValueListDtoToSettingsValueList(apiService.getSettingsValue(value))
    }
}