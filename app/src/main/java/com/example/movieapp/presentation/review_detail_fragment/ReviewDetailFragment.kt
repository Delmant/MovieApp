package com.example.movieapp.presentation.review_detail_fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.movieapp.databinding.FragmentReviewDetailBinding
import com.example.movieapp.presentation.MovieApp
import com.example.movieapp.presentation.ViewModelFactory
import com.example.movieapp.presentation.adapters.review_detail.ReviewAdapter
import kotlinx.coroutines.delay
import javax.inject.Inject

class ReviewDetailFragment : Fragment() {

    private var _binding: FragmentReviewDetailBinding? = null
    private val binding: FragmentReviewDetailBinding
        get() = _binding ?: throw RuntimeException("")

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private var viewModel: ReviewDetailViewModel? = null

    private val component by lazy {
        (requireActivity().application as MovieApp).component
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        component.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory)[ReviewDetailViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentReviewDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val arguments = requireArguments().getInt(EXTRA_MOVIE_ID)
        viewModel?.getReview(arguments)
        viewModel?.state?.observe(viewLifecycleOwner) {
            when(it) {
                is ReviewState.Initial -> {

                }
                is ReviewState.IsLoading -> {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.contentContainer.visibility = View.GONE
                }
                is ReviewState.IsError -> {

                }
                is ReviewState.Result -> {
                    val adapter = ReviewAdapter(it.review.list)
                    binding.vpViewPager.adapter = adapter
                    binding.btnClose.setOnClickListener {
                        parentFragmentManager.popBackStack()
                    }
                    binding.progressBar.visibility = View.VISIBLE
                    binding.contentContainer.visibility = View.GONE
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        private const val EXTRA_MOVIE_ID = "movie_id"

        fun newInstance(movieId: Int): ReviewDetailFragment {
            return ReviewDetailFragment().apply {
                arguments = Bundle().apply {
                    putInt(EXTRA_MOVIE_ID, movieId)
                }
            }
        }
    }
}