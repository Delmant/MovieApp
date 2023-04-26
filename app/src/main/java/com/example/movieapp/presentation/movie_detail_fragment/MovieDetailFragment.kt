package com.example.movieapp.presentation.movie_detail_fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.movieapp.databinding.FragmentMovieDetailBinding
import com.example.movieapp.domain.model.Country
import com.example.movieapp.domain.model.Genres
import com.example.movieapp.domain.model.Movie
import com.example.movieapp.domain.model.Persons
import com.example.movieapp.domain.model.Poster
import com.example.movieapp.domain.model.Rating
import com.example.movieapp.domain.model.SequelsAndPrequels
import com.example.movieapp.domain.model.SimilarMovies
import com.example.movieapp.domain.model.Videos
import com.example.movieapp.domain.model.Votes
import com.example.movieapp.presentation.MovieApp
import com.example.movieapp.presentation.ViewModelFactory
import com.example.movieapp.presentation.movie_detail_fragment.actor.ActorAdapter
import com.example.movieapp.presentation.movie_detail_fragment.rating.RatingAdapter
import com.example.movieapp.presentation.movie_detail_fragment.similar_movies.SimilarMovieAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import javax.inject.Inject

class MovieDetailFragment: Fragment() {

    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private var _bindingInfo: FragmentMovieDetailBinding? = null
    private lateinit var viewModel: MovieDetailViewModel

    private val component by lazy {
        (requireActivity().application as MovieApp).component
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        component.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory)[MovieDetailViewModel::class.java]
    }
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
        val id = requireArguments().getInt(EXTRA_MOVIE_ID)

        coroutineScope.launch {
            viewModel.getMovieById(id).observe(viewLifecycleOwner) {
                setupSequelsRv(it.sequelsAndPrequels)
                setupSimilarRv(it.similarMovies)
                setupActorRv(it.persons)
                setupRatingRv(it.rating, it.votes)
                setupBtnPlayTrailer(it.videos)
                setupPoster(it.poster)
                setupPersons(it.persons)
                setupDescription(it.description)
                setupVotes(it.votes)
                setupRating(it.rating)
                setupYearAndGenres(it.year, it.genres)
                setupCountryLengthAndPg(it.countries, it.movieLength, it.ageRating)
                setupNames(it.name, it.alternativeName)
            }
        }
        setupBtnClose()
    }

    private fun setupBtnClose() {
        binding.btnClose.setOnClickListener {
            fragmentManager?.popBackStack()
        }
    }

    private fun setupNames(name: String, altName: String) {
        binding.tvTitle.text = name
        binding.tvTitleEn.text = altName
    }

    private fun setupCountryLengthAndPg(country: List<Country>, movieLength: Int, ageRating: Int) {
        binding.tvCountryLengthPg.text = viewModel.parseCountryLengthAndPg(
            country, movieLength, ageRating
        )
    }

    private fun setupYearAndGenres(year: Int, genres: List<Genres>) {
        binding.tvYearAndGenres.text = viewModel.parseYearAndGenres(
           year, genres
        )
    }

    private fun setupRating(rating: Rating) {
        binding.tvKpRating.text = viewModel.parseRating(rating.kp)
        binding.tvKpRating.setTextColor(viewModel.setupRatingColor(rating.kp))
    }

    private fun setupVotes(votes: Votes) {
        binding.tvVotes.text = viewModel.parseVotes(votes.kp)
    }

    private fun setupDescription(desc: String) {
        binding.tvDescriptionText.text = desc
    }
    private fun setupPersons(persons: List<Persons>) {
        binding.tvActors.text = viewModel.parsePersons(persons)
    }

    private fun setupPoster(poster: Poster) {
        Glide.with(this)
            .load(poster.url)
            .into(binding.ivMovie)
    }

    private fun setupBtnPlayTrailer(videos: Videos) {
        binding.btnPlayTrailer.setOnClickListener {
            viewModel.openYouTube(requireContext(), videos.trailers)
        }
    }

    private fun setupRatingRv(rating: Rating, votes: Votes) {
        val adapter = RatingAdapter(viewModel.makePairRatingAndVotes(rating, votes))
        binding.rvRating.adapter = adapter
    }

    private fun setupActorRv(list: List<Persons>) {
        val actorAdapter = ActorAdapter(list, requireContext())
        binding.rvActor.adapter = actorAdapter
    }

    private fun setupSimilarRv(list: List<SimilarMovies>) {
        val similarMoviesAdapter = SimilarMovieAdapter(requireContext())
        binding.rvSimilarMovies.adapter = similarMoviesAdapter
        similarMoviesAdapter.submitList(list)
    }

    private fun setupSequelsRv(list: List<SequelsAndPrequels>) {
        val sequelsAdapter = SimilarMovieAdapter(requireContext())
        binding.rvSeqMovies.adapter = sequelsAdapter
        sequelsAdapter.submitList(viewModel.similarToSequels(list))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _bindingInfo = null
        coroutineScope.cancel()
    }

    companion object {

        private const val EXTRA_MOVIE_KEY = "movie_key"
        private const val EXTRA_MOVIE_ID = "movie_id"

        fun newInstance(movieId: Int): MovieDetailFragment {
            return MovieDetailFragment().apply {
                arguments = Bundle().apply {
                    putInt(EXTRA_MOVIE_ID, movieId)
                }
            }
        }
    }
}