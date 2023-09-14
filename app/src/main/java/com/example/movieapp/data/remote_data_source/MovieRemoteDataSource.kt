package com.example.movieapp.data.remote_data_source

import com.example.movieapp.data.remote_data_source.model.actor_dto.ActorDto
import com.example.movieapp.data.remote_data_source.model.image_dto.ImageListDto
import com.example.movieapp.data.remote_data_source.model.movie_dto.MovieDto
import com.example.movieapp.data.remote_data_source.model.movie_list_dto.MovieListDto
import com.example.movieapp.data.remote_data_source.model.review_dto.ReviewListDto

interface MovieRemoteDataSource {

    suspend fun getMovieById(id: Int): MovieDto

    suspend fun getSearchResultByMovieName(movieName: String): MovieListDto

    suspend fun getImageByMovieId(movieId: Int): ImageListDto

    suspend fun getPersonById(personId: Int): ActorDto

    suspend fun getReviewByMovieId(movieId: Int): ReviewListDto
}