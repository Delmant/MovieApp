package com.example.movieapp.presentation.review_list_fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.movieapp.databinding.FragmentReviewListBinding
import com.example.movieapp.presentation.MovieApp
import com.example.movieapp.presentation.ViewModelFactory
import com.example.movieapp.presentation.adapters.review_list.ReviewListAdapter
import com.example.movieapp.presentation.adapters.review_page_number.ReviewPageNumberAdapter
import javax.inject.Inject

class ReviewListFragment: Fragment() {

    private var _binding: FragmentReviewListBinding? = null
    private val binding: FragmentReviewListBinding
        get() = _binding ?: throw RuntimeException("")

    private val component by lazy {
        (requireActivity().application as MovieApp).component
    }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private var viewModel: ReviewListViewModel? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        component.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory)[ReviewListViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentReviewListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = requireArguments().getInt(EXTRA_MOVIE_ID)
        val pages = requireArguments().getInt(EXTRA_PAGES)
        val listPages = mutableListOf<Int>()
        repeat(pages) {
            listPages.add(it + 1)
        }

        viewModel?.getReview(id, START_PAGE)

        viewModel?.movieLiveDataReview?.observe(viewLifecycleOwner) {
            val adapter = ReviewListAdapter(id, it.list)
            binding.rvReviewList.adapter = adapter
        }

        val adapterPages = ReviewPageNumberAdapter(listPages)
        binding.rvPageNumber.adapter = adapterPages

        adapterPages.listener = object : ReviewPageNumberAdapter.OnItemClickListener {
            override fun onClick(page: Int) {
                viewModel?.getReview(id, page)

                viewModel?.movieLiveDataReview?.observe(viewLifecycleOwner) {
                    val adapter = ReviewListAdapter(id, it.list)
                    binding.rvReviewList.adapter = adapter
                }
            }

        }

        binding.ivBtnClose.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        private const val START_PAGE = 1

        private const val EXTRA_MOVIE_ID = "extra_movie_id"
        private const val EXTRA_PAGES = "extra_pages"

        fun newInstance(movieId: Int, pages: Int): ReviewListFragment {
            return ReviewListFragment().apply {
                arguments = Bundle().apply {
                    putInt(EXTRA_MOVIE_ID, movieId)
                    putInt( EXTRA_PAGES, pages)
                }
            }
        }
    }
}