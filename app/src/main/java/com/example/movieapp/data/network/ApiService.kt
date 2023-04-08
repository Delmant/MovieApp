package com.example.movieapp.data.network

import com.example.movieapp.data.network.model.MovieDto
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



    companion object {
        private const val MEDIA_TYPE = "accept: application/json"
        private const val API_KEY = "X-API-KEY: A19YWK7-537M89V-MFJQD6P-FPV15RV"

        private const val PATH_PARAM_ID = "PATH_PARAM_ID"
        private const val PAGE_PARAM_NUMBER = "page"
        private const val PAGE_PARAM_LIMIT = "limit"
    }
}