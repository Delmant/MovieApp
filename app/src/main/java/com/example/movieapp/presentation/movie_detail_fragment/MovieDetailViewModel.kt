package com.example.movieapp.presentation.movie_detail_fragment

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.domain.model.image.Image
import com.example.movieapp.domain.model.image.ImageList
import com.example.movieapp.domain.model.movie.Country
import com.example.movieapp.domain.model.movie.Facts
import com.example.movieapp.domain.model.movie.Genres
import com.example.movieapp.domain.model.movie.Movie
import com.example.movieapp.domain.model.movie.Persons
import com.example.movieapp.domain.model.movie.Rating
import com.example.movieapp.domain.model.movie.SequelsAndPrequels
import com.example.movieapp.domain.model.movie.SimilarMovies
import com.example.movieapp.domain.model.movie.Trailers
import com.example.movieapp.domain.model.movie.Votes
import com.example.movieapp.domain.model.review.Review
import com.example.movieapp.domain.model.review.ReviewList
import com.example.movieapp.domain.reaction.Reaction
import com.example.movieapp.domain.usecases.GetImageByMovieIdUseCase
import com.example.movieapp.domain.usecases.GetMovieByIdUseCase
import com.example.movieapp.domain.usecases.GetReviewByMovieIdUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class MovieDetailViewModel @Inject constructor(
    private val getMovieByIdUseCase: GetMovieByIdUseCase,
    private val getImageByMovieIdUseCase: GetImageByMovieIdUseCase,
    private val getReviewByMovieIdUseCase: GetReviewByMovieIdUseCase
) : ViewModel() {

    private val _movieLiveData = MutableLiveData<Movie>()
    val movieLiveData: LiveData<Movie> = _movieLiveData

    private val _movieLiveDataImages = MutableLiveData<ImageList>()
    val movieLiveDataImages: LiveData<ImageList> = _movieLiveDataImages

    private val _movieLiveDataReview = MutableLiveData<ReviewList>()
    val movieLiveDataReview: LiveData<ReviewList> = _movieLiveDataReview

    private val _state = MutableLiveData<MovieDetailState>(MovieDetailState.Initial)
    val state = _state

    fun getMovieById(id: Int) {
        viewModelScope.launch {
            _state.value = MovieDetailState.IsLoading
            val movie = getMovieByIdUseCase.invoke(id)
            val image = getImageByMovieIdUseCase.invoke(id)
            val review = getReviewByMovieIdUseCase.invoke(id, START_PAGE_NUMBER_REVIEW)
            var movieResult: Movie? = null
            var imageListResult: ImageList? = null
            var reviewResult: ReviewList? = null

            when(movie) {
                is Reaction.Success -> {
                    movieResult = movie.data
                }
                is Reaction.Error -> {

                }
            }

            when(image) {
                is Reaction.Success -> {
                    imageListResult = image.data
                }
                is Reaction.Error -> {

                }
            }

            when(review) {
                is Reaction.Success -> {
                    reviewResult = review.data
                }
                is Reaction.Error -> {

                }
            }
            _state.value = MovieDetailState.Result(
                movie = movieResult,
                imageList = imageListResult,
                review = reviewResult
            )
        }
    }

    fun openYouTube(context: Context, trailers: List<Trailers>) {
        val link = parseTrailer(trailers)
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        intent.setPackage("com.google.android.youtube")

        context.startActivity(intent)
    }

    private fun parseTrailer(trailers: List<Trailers>): String {
        trailers.forEach {
            if (it.site == YOUTUBE_KEY_WORD) {
                return it.url
            }
        }
        return ""
    }

    fun similarToSequels(list: List<SequelsAndPrequels>): List<SimilarMovies> {
        return list.map {
            SimilarMovies(
                alternativeName = it.alternativeName,
                enName = it.enName,
                id = it.id,
                name = it.name,
                poster = it.poster,
                type = it.type
            )
        }
    }

    companion object {

        private const val START_PAGE_NUMBER_REVIEW = 1
        private const val YOUTUBE_KEY_WORD = "youtube"
    }
}