package com.example.movieapp.presentation.movie_detail_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.movieapp.domain.model.Movie

class MovieDetailFragment: Fragment() {



    companion object {

        private const val EXTRA_MOVIE_KEY = "movie_key"

        fun newInstance(movie: Movie): MovieDetailFragment {
            return MovieDetailFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(EXTRA_MOVIE_KEY, movie)
                }
            }
        }
    }
}