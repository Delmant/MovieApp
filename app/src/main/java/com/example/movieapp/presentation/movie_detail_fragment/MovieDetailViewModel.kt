package com.example.movieapp.presentation.movie_detail_fragment

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.lifecycle.ViewModel
import com.example.movieapp.domain.model.Country
import com.example.movieapp.domain.model.Genres
import com.example.movieapp.domain.model.Persons
import com.example.movieapp.domain.model.Trailers
import com.example.movieapp.domain.usecases.GetMovieByIdUseCase
import javax.inject.Inject

class MovieDetailViewModel @Inject constructor(

) : ViewModel() {


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

    fun parseCountryLengthAndPg(listCountry: List<Country>, length: Int): String {
        return "${listCountry[0].name}, ${parseMovieLength(length)}"
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
}