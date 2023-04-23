package com.example.movieapp.presentation.movie_detail_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.data.mapper.MovieMapper
import com.example.movieapp.data.network.ApiFactory
import com.example.movieapp.databinding.FragmentMovieDetailBinding
import com.example.movieapp.databinding.FragmentMovieDetailInfoBinding
import com.example.movieapp.domain.model.Movie
import com.example.movieapp.domain.model.SimilarMovies
import com.example.movieapp.presentation.MovieListFragment
import com.example.movieapp.presentation.movie_detail_fragment.similar_movies.SimilarMovieAdapter
import com.example.movieapp.presentation.rv.MovieAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieDetailFragment: Fragment() {

    private var _bindingInfo: FragmentMovieDetailBinding? = null

    private var apiService = ApiFactory.apiService

    private val coroutineScope = CoroutineScope(Dispatchers.Default)

    private lateinit var viewModel: MovieDetailViewModel
    private val binding: FragmentMovieDetailBinding
        get() = _bindingInfo ?: throw RuntimeException("FragmentMovieDetailInfoBinding is null")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _bindingInfo = FragmentMovieDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val movie = requireArguments().get(EXTRA_MOVIE_KEY) as Movie
        viewModel = ViewModelProvider(this)[MovieDetailViewModel::class.java]


        binding.tvTitle.text = movie.name
        binding.tvTitleEn.text = movie.alternativeName
        binding.btnClose.setOnClickListener {
            fragmentManager?.popBackStack()
        }

        binding.tvCountryLengthPg.text = viewModel.parseCountryLengthAndPg(
            movie.countries, movie.movieLength
        )

        binding.tvYearAndGenres.text = viewModel.parseYearAndGenres(
            movie.year, movie.genres
        )

        binding.tvKpRating.text = viewModel.parseRating(movie.rating.kp)
        binding.tvKpRating.setTextColor(viewModel.setupRatingColor(movie.rating.kp))

        binding.tvVotes.text = viewModel.parseVotes(movie.votes.kp)


        binding.tvDescriptionText.text = movie.description

        binding.tvActors.text = viewModel.parsePersons(movie.persons)

        Glide.with(this)
            .load(movie.poster.url)
            .into(binding.ivMovie)

        binding.btnPlayTrailer.setOnClickListener {
            viewModel.openYouTube(requireContext(), movie.videos.trailers)
        }



    }

    override fun onDestroyView() {
        super.onDestroyView()
        _bindingInfo = null
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