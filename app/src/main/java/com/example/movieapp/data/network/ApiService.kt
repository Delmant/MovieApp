package com.example.movieapp.data.network

import com.example.movieapp.data.network.model.actor_dto.ActorDto
import com.example.movieapp.data.network.model.image_dto.ImageListDto
import com.example.movieapp.data.network.model.movie_dto.MovieDto
import com.example.movieapp.data.network.model.movie_dto.PersonDto
import com.google.gson.JsonObject
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("movie/random")
    @Headers(
        MEDIA_TYPE,
        API_KEY
    )
    suspend fun getRandomMovie(
    ): MovieDto

    @GET("movie/{PATH_PARAM_ID}")
    @Headers(
        MEDIA_TYPE,
        API_KEY
    )
    suspend fun getMovieById(
        @Path(PATH_PARAM_ID) id: Int
    ): MovieDto

    @GET("movie")
    @Headers(
        MEDIA_TYPE,
        API_KEY
    )
    suspend fun getMovieByPage(
        @Query(PAGE_PARAM_NUMBER) pageNumber: Int,
        @Query(PAGE_PARAM_LIMIT) pageLimit: Int
    ): JsonObject

    @GET("image")
    @Headers(
        MEDIA_TYPE,
        API_KEY
    )
    suspend fun getImageByMovieId(
        @Query(IMAGE_PARAM_MOVIE_ID) movieId: Int,
        @Query(IMAGE_PARAM_TYPE) type: String
    ): ImageListDto

    @GET("person/{PATH_PERSON_ID}")
    @Headers(
        MEDIA_TYPE,
        API_KEY
    )
    suspend fun getPersonById(
        @Path(PATH_PERSON_ID) personId: Int
    ): ActorDto



    companion object {
        private const val MEDIA_TYPE = "accept: application/json"
        private const val API_KEY = "X-API-KEY: A19YWK7-537M89V-MFJQD6P-FPV15RV"

        private const val PATH_PERSON_ID = "PATH_PERSON_ID"
        private const val PATH_PARAM_ID = "PATH_PARAM_ID"
        private const val PAGE_PARAM_NUMBER = "page"
        private const val PAGE_PARAM_LIMIT = "limit"
        private const val IMAGE_PARAM_MOVIE_ID = "movieId"
        private const val IMAGE_PARAM_TYPE = "type"
    }
}