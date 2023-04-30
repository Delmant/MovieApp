package com.example.movieapp.presentation.image_detail_fragment

import android.os.Bundle
import android.view.GestureDetector
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.core.view.GestureDetectorCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.databinding.FragmentImageDetailBinding
import com.example.movieapp.databinding.ImageDetailItemBinding
import com.example.movieapp.presentation.MovieApp
import com.example.movieapp.presentation.ViewModelFactory
import com.example.movieapp.presentation.image_detail_fragment.adapter.ImageDetailAdapter
import com.example.movieapp.presentation.movie_detail_fragment.image.ImageAdapter
import javax.inject.Inject

class ImageDetailFragment : Fragment() {

    private var _binding: FragmentImageDetailBinding? = null
    private val binding: FragmentImageDetailBinding
        get() = _binding ?: throw RuntimeException("")

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    lateinit var viewModel: ImageDetailViewModel

    private val component by lazy {
        (requireActivity().application as MovieApp).component
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        component.inject(this)
        viewModel = ViewModelProvider(this, viewModelFactory)[ImageDetailViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentImageDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args = requireArguments().getInt(EXTRA_MOVIE_ID)
        viewModel.getMovieById(args)
        viewModel.movieLiveDataImages.observe(viewLifecycleOwner) {
            val adapter = ImageDetailAdapter(it.imageList, requireContext())
            binding.vpViewPager.adapter = adapter
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        private const val EXTRA_MOVIE_ID = "movie_id"

        fun newInstance(movieId: Int): ImageDetailFragment {
            return ImageDetailFragment().apply {
                arguments = Bundle().apply {
                    putInt(EXTRA_MOVIE_ID, movieId)
                }
            }
        }
    }
}