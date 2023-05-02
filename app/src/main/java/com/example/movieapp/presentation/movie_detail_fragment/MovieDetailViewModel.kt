package com.example.movieapp.presentation.movie_detail_fragment

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.net.Uri
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
import com.example.movieapp.domain.model.review.ReviewList
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

    fun getMovieById(id: Int) {
        viewModelScope.launch {
            val movie = getMovieByIdUseCase.invoke(id)
            val image = getImageByMovieIdUseCase.invoke(id)
            val review = getReviewByMovieIdUseCase.invoke(id)
            _movieLiveData.value = movie
            _movieLiveDataImages.value = image
            _movieLiveDataReview.value = review
        }
    }

    fun parseFacts(facts: List<Facts>): List<Facts> {
        val removeHtmlFacts = facts.map {
            it.copy(value = it.value.replace(Regex("<.*?>"), ""))

        }
        val removeAppFacts = removeHtmlFacts.map {
            it.copy(value = it.value.replace(Regex("&.*?;"), ""))
        }
        return removeAppFacts
    }
    fun setupRatingColor(rating: Double): Int {
        if (rating >= 7.0) return Color.GREEN
        if (rating <= 4.5) return Color.RED
        return Color.GRAY
    }

    fun parseRating(rating: Double): String {
        return rating.toString().substring(0, 3) + " "
    }

    fun parseVotes(votes: String): String {
        if (votes.length > 3) return votes.substring(0, votes.length - 3) + "k "
        if (votes.length > 4) return votes.substring(0, votes.length - 6) + "k "
        if (votes.length > 5) return votes.substring(0, votes.length - 9) + "k "
        if (votes.length > 6) return votes.substring(0, votes.length - 12) + "k "
        return "$votes "
    }

    fun parseYearAndGenres(year: Int, genres: List<Genres>): String {
        return "$year, ${genres[0].name}, ${genres[1].name}"
    }

    fun parseCountryLengthAndPg(listCountry: List<Country>, length: Int, ageRating: Int): String {
        return "${listCountry[0].name}, ${parseMovieLength(length)}, $ageRating+"
    }

    private fun parseMovieLength(length: Int): String {
        if (length < 60) return "$length мин"
        val h = length / 60
        val m = length % 60
        return "$h ч $m мин"
    }

    fun parsePersons(list: List<Persons>): String {
        return "В ролях: ${list[0].name}, ${list[1].name}, ${list[2].name}, ${list[3].name} и другие"
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
            if (it.site == "youtube") {
                return it.url
            }
        }
        return ""
    }

    fun makePairRatingAndVotes(
        rating: Rating,
        votes: Votes,
    ): List<Pair<String, Pair<String, String>>> {
        val newList = mutableListOf<Pair<String, Pair<String, String>>>()
        newList.add("Рейтинг кинопоиска" to Pair(rating.kp.toString(), votes.kp))
        newList.add("Рейтинг imdb" to Pair(rating.imdb.toString(), votes.imdb))
        newList.add(
            "Рейттинг мировых критиков" to Pair(
                rating.filmCritics.toString(),
                votes.filmCritics.toString()
            )
        )
        return newList
    }

    private fun checkEmpty(number: Int): String {
        return if (number <= 0) ""
        else "$number"
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
}