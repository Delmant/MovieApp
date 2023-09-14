package com.example.movieapp.data.remote_data_source

import com.example.movieapp.data.remote_data_source.model.actor_dto.ActorDto
import com.example.movieapp.data.remote_data_source.model.image_dto.ImageListDto
import com.example.movieapp.data.remote_data_source.model.movie_dto.MovieDto
import com.example.movieapp.data.remote_data_source.model.movie_list_dto.MovieListDto
import com.example.movieapp.data.remote_data_source.model.review_dto.ReviewListDto
import javax.inject.Inject

class MovieRemoteDataSourceImpl @Inject constructor(
    private val apiService: ApiService
): MovieRemoteDataSource {

    override suspend fun getMovieById(id: Int): MovieDto {
        return apiService.getMovieById(id)
    }

    override suspend fun getSearchResultByMovieName(movieName: String): MovieListDto {
        return apiService.getSearchResult(name = movieName)
    }

    override suspend fun getImageByMovieId(movieId: Int): ImageListDto {
        return apiService.getImageByMovieId(movieId, IMAGE_TYPE_ONE, IMAGE_TYPE_TWO)
    }

    override suspend fun getPersonById(personId: Int): ActorDto {
        TODO("Not yet implemented")
    }

    override suspend fun getReviewByMovieId(movieId: Int): ReviewListDto {
        TODO("Not yet implemented")
    }

    companion object {

        private const val IMAGE_TYPE_ONE = "screenshot"
        private const val IMAGE_TYPE_TWO = "still"
    }
}