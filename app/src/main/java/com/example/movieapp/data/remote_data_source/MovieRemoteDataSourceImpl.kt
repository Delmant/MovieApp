package com.example.movieapp.data.remote_data_source

import com.example.movieapp.data.remote_data_source.model.actor_dto.ActorDto
import com.example.movieapp.data.remote_data_source.model.image_dto.ImageListDto
import com.example.movieapp.data.remote_data_source.model.movie_dto.MovieDto
import com.example.movieapp.data.remote_data_source.model.movie_list_dto.MovieListDto
import com.example.movieapp.data.remote_data_source.model.review_dto.ReviewListDto
import com.example.movieapp.domain.reaction.Reaction
import java.lang.Exception
import javax.inject.Inject

class MovieRemoteDataSourceImpl @Inject constructor(
    private val apiService: ApiService
) : MovieRemoteDataSource {

    override suspend fun getMovieById(id: Int): Reaction<MovieDto> {
        return try {
            Reaction.Success(
                data = apiService.getMovieById(id)
            )
        } catch (e: Exception) {
            handleApiException(e)
        }
    }

    override suspend fun getSearchResultByMovieName(movieName: String): MovieListDto {
        return apiService.getSearchResult(name = movieName)
    }

    override suspend fun getImageByMovieId(movieId: Int): Reaction<ImageListDto> {
        return try {
            Reaction.Success(
                data = apiService.getImageByMovieId(movieId, IMAGE_TYPE_ONE, IMAGE_TYPE_TWO)
            )
        } catch (e: Exception) {
            handleApiException(e)
        }
    }

    override suspend fun getPersonById(personId: Int): Reaction<ActorDto> {
        return try {
            Reaction.Success(
                data = apiService.getPersonById(personId)
            )
        } catch (e: Exception) {
            handleApiException(e)
        }
    }

    override suspend fun getReviewByMovieId(movieId: Int, page: Int): Reaction<ReviewListDto> {
        return try {
            Reaction.Success(
                data = apiService.getReviewByMovieId(movieId, page)
            )
        } catch (e: Exception) {
            handleApiException(e)
        }
    }

    private fun handleApiException(e: Exception): Reaction.Error =
        Reaction.Error(exception = e)

    companion object {

        private const val IMAGE_TYPE_ONE = "screenshot"
        private const val IMAGE_TYPE_TWO = "still"
    }
}