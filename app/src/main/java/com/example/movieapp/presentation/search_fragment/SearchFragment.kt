package com.example.movieapp.presentation.search_fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentSearchBinding
import com.example.movieapp.presentation.MovieApp
import com.example.movieapp.presentation.ViewModelFactory
import com.example.movieapp.presentation.adapters.search.SearchAdapter
import com.example.movieapp.presentation.movie_detail_fragment.MovieDetailFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding: FragmentSearchBinding
        get() = _binding ?: throw RuntimeException("")

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private var viewModel: SearchViewModel? = null

    val coroutineScope = CoroutineScope(Dispatchers.Main)

    private val component by lazy {
        (requireActivity().application as MovieApp).component
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        component.inject(this)
        viewModel = ViewModelProvider(this, viewModelFactory)[SearchViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.progressBar.visibility = View.GONE
        binding.searchView.setOnQueryTextListener(object :
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                search(query.toString())
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                search(newText.toString())
                return false
            }

        })

    }

    fun search(newText: String) {
        viewLifecycleOwner.lifecycleScope.launch {
            binding.progressBar.visibility = View.VISIBLE
            binding.rvMovie.visibility = View.GONE
            viewModel?.getSearchResult(newText)
            viewModel?.searchLiveData?.observe(viewLifecycleOwner) {
                val adapter = SearchAdapter(requireContext())
                adapter.submitList(it.list)
                binding.rvMovie.adapter = adapter
                adapter.listener = object : SearchAdapter.OnItemClick {
                    override fun onClick(movieId: Int) {
                        parentFragmentManager.beginTransaction().add(
                            R.id.fragment_container, MovieDetailFragment.newInstance(movieId)
                        ).addToBackStack(null).commit()
                    }

                }
            }
            delay(800)
            binding.progressBar.visibility = View.GONE
            binding.rvMovie.visibility = View.VISIBLE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        fun newInstance(): SearchFragment {
            return SearchFragment()
        }
    }
}