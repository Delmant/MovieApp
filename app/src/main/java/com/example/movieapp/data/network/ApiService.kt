package com.example.movieapp.data.network

import com.example.movieapp.data.network.model.settings_dto.SettingsValueDto
import com.example.movieapp.data.network.model.actor_dto.ActorDto
import com.example.movieapp.data.network.model.image_dto.ImageListDto
import com.example.movieapp.data.network.model.movie_dto.MovieDto
import com.example.movieapp.data.network.model.movie_list_dto.MovieListDto
import com.example.movieapp.data.network.model.review_dto.ReviewListDto
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

    @GET("v1.3/movie/{PATH_PARAM_ID}")
    @Headers(
        MEDIA_TYPE,
        API_KEY
    )
    suspend fun getMovieById(
        @Path(PATH_PARAM_ID) id: Int
    ): MovieDto

    @GET("v1.3/movie")
    @Headers(
        MEDIA_TYPE,
        API_KEY
    )
    suspend fun getSearchResult(
        @Query(SEARCH_PARAM_NAME) name: String
    ): MovieListDto

    @GET("movie")
    @Headers(
        MEDIA_TYPE,
        API_KEY
    )
    suspend fun getMovieByPage(
        @Query(PAGE_PARAM_NUMBER) pageNumber: Int,
        @Query(PAGE_PARAM_LIMIT) pageLimit: Int
    ): JsonObject

    @GET("v1/image")
    @Headers(
        MEDIA_TYPE,
        API_KEY
    )
    suspend fun getImageByMovieId(
        @Query(IMAGE_PARAM_MOVIE_ID) movieId: Int,
        @Query(IMAGE_PARAM_TYPE) type1: String,
        @Query(IMAGE_PARAM_TYPE) type2: String
    ): ImageListDto

    @GET("v1/person/{PATH_PERSON_ID}")
    @Headers(
        MEDIA_TYPE,
        API_KEY
    )
    suspend fun getPersonById(
        @Path(PATH_PERSON_ID) personId: Int
    ): ActorDto

    @GET("v1/review")
    @Headers(
        Companion.MEDIA_TYPE,
        Companion.API_KEY
    )
    suspend fun getReviewByMovieId(
        @Query(REVIEW_PARAM_MOVIE_ID) movieId: Int,
        @Query(REVIEW_PARAM_PAGE_NUMBER) page: Int
    ): ReviewListDto

    @GET("v1/movie/possible-values-by-field")
    @Headers(
        MEDIA_TYPE,
        API_KEY
    )
    suspend fun getSettingsValue(
        @Query(SETTINGS_PARAM_VALUE) field: String
    ): List<SettingsValueDto>
    
    companion object {
        private const val MEDIA_TYPE = "accept: application/json"
        private const val API_KEY = "X-API-KEY: A19YWK7-537M89V-MFJQD6P-FPV15RV"

        private const val PATH_PERSON_ID = "PATH_PERSON_ID"
        private const val PATH_PARAM_ID = "PATH_PARAM_ID"
        private const val PAGE_PARAM_NUMBER = "page"
        private const val PAGE_PARAM_LIMIT = "limit"
        private const val IMAGE_PARAM_MOVIE_ID = "movieId"
        private const val IMAGE_PARAM_TYPE = "type"

        private const val SETTINGS_PARAM_VALUE = "field"

        private const val REVIEW_PARAM_MOVIE_ID = "movieId"
        private const val REVIEW_PARAM_PAGE_NUMBER = "page"

        private const val SEARCH_PARAM_NAME = "name"

        private const val QUERY_PERSON_ID = "persons.id"
    }
}