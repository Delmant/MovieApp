package com.example.movieapp.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.movieapp.R
import com.example.movieapp.databinding.MovieListBinding
import com.example.movieapp.domain.model.movie.Movie
import com.example.movieapp.presentation.movie_detail_fragment.MovieDetailFragment
import com.example.movieapp.presentation.adapters.movie.MovieAdapter
import java.lang.RuntimeException

class MovieListFragment : Fragment() {

    private var _binding: MovieListBinding? = null
    private val binding: MovieListBinding
        get() = _binding ?: throw RuntimeException("MovieListBinding is null")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = MovieListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val movie = requireArguments().get(MOVIE_KEY_WORD)
        val list = mutableListOf<Movie>()
        repeat(20) {
            list.add(movie as Movie)
        }
        val adapter = MovieAdapter(requireContext())
        binding.rvMovies.adapter = adapter
        binding.rvMovies.layoutManager = GridLayoutManager(requireContext(), 4)
        adapter.submitList(list)
        adapter.listener = object : MovieAdapter.OnItemClickListener {
            override fun onItemClick(movieId: Int) {
                fragmentManager?.beginTransaction()
                    ?.add(R.id.fragment_container, MovieDetailFragment.newInstance(movieId))
                    ?.addToBackStack(null)?.commit()
            }

        }
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