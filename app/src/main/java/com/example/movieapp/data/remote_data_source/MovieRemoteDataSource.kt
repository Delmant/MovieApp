package com.example.movieapp.data.remote_data_source

import com.example.movieapp.data.network.model.actor_dto.ActorDto
import com.example.movieapp.data.network.model.image_dto.ImageListDto
import com.example.movieapp.data.network.model.movie_dto.MovieDto
import com.example.movieapp.data.network.model.movie_list_dto.MovieListDto
import com.example.movieapp.data.network.model.review_dto.ReviewListDto

interface MovieRemoteDataSource {

    fun getMovieById(id: Int): MovieDto

    fun getSearchResultByMovieName(movieName: String): MovieListDto

    fun getImageByMovieId(movieId: Int): ImageListDto

    fun getPersonById(personId: Int): ActorDto

    fun getReviewByMovieId(movieId: Int): ReviewListDto
}