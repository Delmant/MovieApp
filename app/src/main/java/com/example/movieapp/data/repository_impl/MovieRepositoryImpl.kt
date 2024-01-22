package com.example.movieapp.data.repository_impl


import androidx.lifecycle.LiveData
import com.example.movieapp.data.local_data_source.MovieLocalDataSourceImpl
import com.example.movieapp.data.mapper.MovieMapper
import com.example.movieapp.data.remote_data_source.ApiService
import com.example.movieapp.data.remote_data_source.MovieRemoteDataSource
import com.example.movieapp.domain.model.actor.Actor
import com.example.movieapp.domain.model.image.ImageList
import com.example.movieapp.domain.model.movie.Movie
import com.example.movieapp.domain.model.movie_list.MovieList
import com.example.movieapp.domain.model.review.ReviewList
import com.example.movieapp.domain.model.search_settings.SettingsValue
import com.example.movieapp.domain.reaction.Reaction

import com.example.movieapp.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val movieMapper: MovieMapper,
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSourceImpl: MovieLocalDataSourceImpl
) : MovieRepository {


    override suspend fun getMovieById(id: Int): Reaction<Movie> {
        val result = movieRemoteDataSource.getMovieById(id)
        return when(result) {
            is Reaction.Success -> {
                Reaction.Success(
                    data = movieMapper.toEntity(result.data)
                )
            }

            is Reaction.Error -> {
                Reaction.Error(
                    exception = result.exception
                )
            }
        }
    }

    override suspend fun getSearchResult(name: String): MovieList {
        return movieMapper.movieListDtoToMovieList(apiService.getSearchResult(name))
    }

    override suspend fun getImageByMovieId(id: Int): Reaction<ImageList> {
        val result = movieRemoteDataSource.getImageByMovieId(id)
        return when(result) {
            is Reaction.Success -> {
                Reaction.Success(
                    data = movieMapper.imageListDtoToImageListEntity(result.data)
                )
            }
            is Reaction.Error -> {
                Reaction.Error(
                    exception = result.exception
                )
            }
        }
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

    override suspend fun getPersonById(id: Int): Reaction<Actor> {
        val result = movieRemoteDataSource.getPersonById(id)
        return when(result) {
            is Reaction.Success -> {
                Reaction.Success(
                    data = movieMapper.actorDtoToActorEntity(result.data)
                )
            }
            is Reaction.Error -> {
                Reaction.Error(
                    exception = result.exception
                )
            }
        }
    }

    override suspend fun getReviewByMovieId(id: Int, page: Int): Reaction<ReviewList> {
        return when(val reviewList = movieRemoteDataSource.getReviewByMovieId(id, page)) {
            is Reaction.Success -> {
                Reaction.Success(
                    data = movieMapper.reviewListDtoToReviewList(reviewList.data)
                )
            }
            is Reaction.Error -> {
                Reaction.Error(
                    exception = reviewList.exception
                )
            }
        }
    }

    override suspend fun loadData() {
        TODO("Not yet implemented")
    }

    override suspend fun getSettingsValue(value: String): List<SettingsValue> {
        return movieMapper.settingsValueListDtoToSettingsValueList(apiService.getSettingsValue(value))
    }

    override fun saveSharedPrefSearchSettings(type: String, gson: String) {
        movieLocalDataSourceImpl.saveSearchSettings(type, gson)
    }

    override fun getSharedPrefSearchSettings() {
        movieLocalDataSourceImpl.getSearchSettings()
    }

    override fun deleteSharedPrefSearchSettings() {
        movieLocalDataSourceImpl.deleteSearchSettings()
    }
}