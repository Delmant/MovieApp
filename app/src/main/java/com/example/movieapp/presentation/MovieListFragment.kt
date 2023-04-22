package com.example.movieapp.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.movieapp.databinding.MovieListBinding
import com.example.movieapp.domain.model.Movie
import java.lang.RuntimeException

class MovieListFragment : Fragment() {

    private var _binding: MovieListBinding? = null
    private val binding: MovieListBinding
        get() = _binding ?: throw RuntimeException("MovieListBinding is null")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = MovieListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

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