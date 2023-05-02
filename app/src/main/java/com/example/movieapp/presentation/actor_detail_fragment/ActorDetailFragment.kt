package com.example.movieapp.presentation.actor_detail_fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentActorDetailInfoBinding
import com.example.movieapp.domain.model.actor.MovieAct
import com.example.movieapp.domain.model.actor.Profession
import com.example.movieapp.domain.model.movie.Facts
import com.example.movieapp.domain.model.movie.Persons
import com.example.movieapp.domain.model.movie.SimilarMovies
import com.example.movieapp.presentation.MovieApp
import com.example.movieapp.presentation.ViewModelFactory
import com.example.movieapp.presentation.adapters.actor_movies.ActorMoviesAdapter
import com.example.movieapp.presentation.movie_detail_fragment.MovieDetailFragment
import com.example.movieapp.presentation.adapters.fact.FactAdapter
import com.example.movieapp.presentation.adapters.similar_movies.SimilarMovieAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.RuntimeException
import javax.inject.Inject

class ActorDetailFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var viewModel: ActorDetailViewModel

    var _bindng: FragmentActorDetailInfoBinding? = null
    val binding: FragmentActorDetailInfoBinding
        get() = _bindng ?: throw RuntimeException("")

    private val component by lazy {
        (requireActivity().application as MovieApp).component
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        component.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory)[ActorDetailViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _bindng = FragmentActorDetailInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    val coroutineScope = CoroutineScope(Dispatchers.Main)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id = requireArguments().getInt(EXTRA_PERSON_ID)
        binding.container.visibility = View.GONE

        coroutineScope.launch {
            viewModel.getPerson(id)

            viewModel.personLiveData.observe(viewLifecycleOwner) {
                setupActorName(it.name, it.enName)
                setupActorPhoto(it.photo)
                setupFactsRv(viewModel.convertFactsList(it.actorFacts))
                setupActorMovie(it.movies)
                setupActorProfession(it.profession)
                setupAgeAndGrowth(it.age, it.growth)
                setupDateOfBirthActor(it.birthday)

                binding.progressBar.visibility = View.GONE
                binding.container.visibility = View.VISIBLE

            }
        }
        setupBtnClose()
    }

    private fun setupActorMovie(list: List<MovieAct>) {
        val adapter = ActorMoviesAdapter(list)
        binding.rvSeqMovies.adapter = adapter
        adapter.listener = object : ActorMoviesAdapter.OnItemClickListener {
            override fun onItemClick(movieId: Int) {
                parentFragmentManager.beginTransaction()
                    .add(R.id.fragment_container, MovieDetailFragment.newInstance(movieId))
                    .addToBackStack(null)?.commit()
            }

        }
    }

    private fun setupDateOfBirthActor(birthday: String) {
        binding.tvDataOfBirth.text = viewModel.parseActorDateOfBirth(birthday)
    }

    private fun setupAgeAndGrowth(age: Int, growth: Int) {
        binding.tvAgeAndGrowth.text = viewModel.setupAgeAndGrowth(age, growth)
    }

    private fun setupActorProfession(list: List<Profession>) {
        binding.tvProfession.text = viewModel.parseActorProfession(list)
    }

    private fun setupActorName(nameRu: String, nameEn: String) {
        binding.tvActorNameRu.text = viewModel.parseName(nameRu)
        binding.tvActorNameEn.text = nameEn
    }

    private fun setupActorPhoto(photo: String) {
        Glide.with(this@ActorDetailFragment)
            .load(photo)
            .into(binding.ivActor)
    }

    private fun setupFactsRv(list: List<Facts>) {
        if(list.isEmpty()) binding.tvFactTitle.visibility = View.GONE
        val adapter = FactAdapter(list)
        binding.rvFact.adapter = adapter
    }
    private fun setupBtnClose() {
        binding.btnClose.setOnClickListener {
            requireFragmentManager().popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _bindng = null
    }

    companion object {

        private const val EXTRA_PERSON_ID = "person_id"

        fun newInstance(personId: Int): ActorDetailFragment {
            return ActorDetailFragment().apply {
                arguments = Bundle().apply {
                    putInt(EXTRA_PERSON_ID, personId)
                }
            }
        }
    }
}