package com.example.movieapp.data.remote_data_source

import com.example.movieapp.data.mapper.MovieMapper
import com.example.movieapp.data.network.ApiService
import com.example.movieapp.data.network.model.actor_dto.ActorDto
import com.example.movieapp.data.network.model.image_dto.ImageListDto
import com.example.movieapp.data.network.model.movie_dto.MovieDto
import com.example.movieapp.data.network.model.movie_list_dto.MovieListDto
import com.example.movieapp.data.network.model.review_dto.ReviewListDto
import javax.inject.Inject

class MovieRemoteDataSourceImpl @Inject constructor(
    val apiService: ApiService
): MovieRemoteDataSource {

    override fun getMovieById(id: Int): MovieDto {
        TODO("Not yet implemented")
    }

    override fun getSearchResultByMovieName(movieName: String): MovieListDto {
        TODO("Not yet implemented")
    }

    override fun getImageByMovieId(movieId: Int): ImageListDto {
        TODO("Not yet implemented")
    }

    override fun getPersonById(personId: Int): ActorDto {
        TODO("Not yet implemented")
    }

    override fun getReviewByMovieId(movieId: Int): ReviewListDto {
        TODO("Not yet implemented")
    }
}