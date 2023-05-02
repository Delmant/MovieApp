package com.example.movieapp.presentation.movie_detail_fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.data.network.ApiFactory
import com.example.movieapp.databinding.FragmentMovieDetailBinding
import com.example.movieapp.domain.model.image.Image
import com.example.movieapp.domain.model.movie.Country
import com.example.movieapp.domain.model.movie.Facts
import com.example.movieapp.domain.model.movie.Genres
import com.example.movieapp.domain.model.movie.Persons
import com.example.movieapp.domain.model.movie.Poster
import com.example.movieapp.domain.model.movie.Rating
import com.example.movieapp.domain.model.movie.SequelsAndPrequels
import com.example.movieapp.domain.model.movie.SimilarMovies
import com.example.movieapp.domain.model.movie.Videos
import com.example.movieapp.domain.model.movie.Votes
import com.example.movieapp.domain.model.review.Review
import com.example.movieapp.presentation.FactDetailFragment
import com.example.movieapp.presentation.MovieApp
import com.example.movieapp.presentation.ViewModelFactory
import com.example.movieapp.presentation.actor_detail_fragment.ActorDetailFragment
import com.example.movieapp.presentation.image_detail_fragment.ImageDetailFragment
import com.example.movieapp.presentation.adapters.actor.ActorAdapter
import com.example.movieapp.presentation.adapters.fact.FactAdapter
import com.example.movieapp.presentation.adapters.genre.GenreAdapter
import com.example.movieapp.presentation.adapters.image.ImageAdapter
import com.example.movieapp.presentation.adapters.rating.RatingAdapter
import com.example.movieapp.presentation.adapters.review_mini.ReviewMiniAdapter
import com.example.movieapp.presentation.adapters.similar_movies.SimilarMovieAdapter
import com.example.movieapp.presentation.review_detail_fragment.ReviewDetailFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import javax.inject.Inject

class MovieDetailFragment : Fragment() {

    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private var _bindingInfo: FragmentMovieDetailBinding? = null

    private val binding: FragmentMovieDetailBinding
        get() = _bindingInfo ?: throw RuntimeException("FragmentMovieDetailInfoBinding is null")

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
        binding.progressBar.visibility = View.VISIBLE
        binding.scrollview.visibility = View.GONE

        viewModel.getMovieById(id)
        viewModel.movieLiveDataImages.observe(viewLifecycleOwner) {
            setupImageRvAndListener(id, it.imageList)
        }
        viewModel.movieLiveDataReview.observe(viewLifecycleOwner) {
            setupReview(id, it.list)
        }
        viewModel.movieLiveData.observe(viewLifecycleOwner) {
            setupPoster(it.poster)
            setupGenreRv(it.genres)
            setupSequelsRv(it.sequelsAndPrequels)
            setupSimilarRv(it.similarMovies)
            setupActorRv(it.persons)
            setupRatingRv(it.rating, it.votes)
            setupBtnPlayTrailer(it.videos)
            setupPersons(it.persons)
            setupDescription(it.description)
            setupVotes(it.votes)
            setupRating(it.rating)
            setupYearAndGenres(it.year, it.genres)
            setupCountryLengthAndPg(it.countries, if(it.isSeries) {it.totalSeriesLength} else it.movieLength, it.ageRating)
            setupNames(it.name, it.alternativeName)
            setupFactsRv(viewModel.parseFacts(it.facts))
            binding.scrollview.visibility = View.VISIBLE
            binding.progressBar.visibility = View.GONE
        }
        setupBtnClose()
    }

    private fun setupImageRvAndListener(id: Int, list: List<Image>) {
        if (list.isEmpty()) binding.tvImageTitle.visibility = View.GONE
        val imageAdapter = ImageAdapter(id, list, requireContext())
        binding.rvImage.adapter = imageAdapter
        imageAdapter.listener = object : ImageAdapter.OnItemClickListener {
            override fun onClick(movieId: Int, position: Int) {
                parentFragmentManager.beginTransaction()
                    .add(R.id.fragment_container, ImageDetailFragment.newInstance(id, position))
                    .addToBackStack(null).commit()
            }
        }
    }

    private fun setupReview(id: Int, list: List<Review>) {
        val adapter = ReviewMiniAdapter(id, list)
        binding.rvReview.adapter = adapter
        adapter.listener = object : ReviewMiniAdapter.OnItemClickListener {
            override fun onClick(movieId: Int) {
                parentFragmentManager.beginTransaction()
                    .add(R.id.fragment_container, ReviewDetailFragment.newInstance(movieId))
                    .addToBackStack(null).commit()
            }

        }
    }

    private fun setupFactsRv(facts: List<Facts>) {
        val adapter = FactAdapter(facts)
        binding.rvFact.adapter = adapter
        adapter.listener = object : FactAdapter.OnItemClickListener {
            override fun onItemClick(fact: String) {
                parentFragmentManager.beginTransaction()
                    .add(R.id.fragment_container, FactDetailFragment.newInstance(fact))
                    .addToBackStack(null).commit()
            }

        }
    }

    private fun setupGenreRv(genres: List<Genres>) {
        val adapter = GenreAdapter(genres)
        binding.rvGenre.adapter = adapter
    }

    private fun setupBtnClose() {
        binding.btnClose.setOnClickListener {
            parentFragmentManager.popBackStack()
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
        actorAdapter.listener = object : ActorAdapter.OnItemClickListener {
            override fun onItemClick(personId: Int) {
                parentFragmentManager.beginTransaction()
                    .add(R.id.fragment_container, ActorDetailFragment.newInstance(personId))
                    .addToBackStack(null).commit()
            }

        }
    }

    private fun setupSimilarRv(list: List<SimilarMovies>) {

        val similarMoviesAdapter = SimilarMovieAdapter(requireContext())
        binding.rvSimilarMovies.adapter = similarMoviesAdapter

        similarMoviesAdapter.submitList(list)
        similarMoviesAdapter.listener = object : SimilarMovieAdapter.OnItemClickListener {
            override fun onItemClick(data: SimilarMovies) {
                parentFragmentManager.beginTransaction()
                    .add(R.id.fragment_container, MovieDetailFragment.newInstance(data.id))
                    .addToBackStack(null).commit()
            }

        }
    }

    private fun setupSequelsRv(list: List<SequelsAndPrequels>) {
        val sequelsAdapter = SimilarMovieAdapter(requireContext())
        binding.rvSeqMovies.adapter = sequelsAdapter
        sequelsAdapter.submitList(viewModel.similarToSequels(list))
        sequelsAdapter.listener = object : SimilarMovieAdapter.OnItemClickListener {
            override fun onItemClick(data: SimilarMovies) {
                parentFragmentManager.beginTransaction()
                    .add(R.id.fragment_container, MovieDetailFragment.newInstance(data.id))
                    .addToBackStack(null).commit()
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _bindingInfo = null
        coroutineScope.cancel()
    }

    companion object {

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