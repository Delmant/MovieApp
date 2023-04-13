package com.example.movieapp.presentation.movie_detail_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.movieapp.databinding.FragmentMovieDetailInfoBinding
import com.example.movieapp.domain.model.Movie

class MovieDetailFragment: Fragment() {

    private var _binding: FragmentMovieDetailInfoBinding? = null
    private val binding: FragmentMovieDetailInfoBinding
        get() = _binding ?: throw RuntimeException("FragmentMovieDetailInfoBinding is null")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMovieDetailInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

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