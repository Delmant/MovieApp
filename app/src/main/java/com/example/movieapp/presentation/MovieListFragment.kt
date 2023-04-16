package com.example.movieapp.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.movieapp.domain.model.Movie

class MovieListFragment : Fragment() {


    companion object {

        private const val MOVIE_KEY_WORD = "movie"

        fun newInstance(movie: Movie): MovieListFragment {
            return MovieListFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(MOVIE_KEY_WORD, movie)
                }
            }
        }
    }
}