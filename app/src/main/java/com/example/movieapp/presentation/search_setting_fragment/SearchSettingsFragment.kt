package com.example.movieapp.presentation.search_setting_fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.movieapp.R
import com.example.movieapp.data.network.ApiFactory
import com.example.movieapp.databinding.FragmentSearchSettingBinding
import com.example.movieapp.presentation.MovieApp
import com.example.movieapp.presentation.ViewModelFactory
import com.example.movieapp.presentation.search_settings_detail_fragment.SearchSettingsDetailFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


class SearchSettingsFragment : Fragment() {

    private var _binding: FragmentSearchSettingBinding? = null
    private val binding: FragmentSearchSettingBinding
        get() = _binding ?: throw RuntimeException("")

    val coroutineScope = CoroutineScope(Dispatchers.IO)

    private var searchSettingsViewModel: SearchSettingsViewModel? = null

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val component by lazy {
        (requireActivity().application as MovieApp).component
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        component.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchSettingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.appBar.text.text = "Поиск лучших фильмов"
        binding.appBar.ivBack.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
        binding.appBar.tvReset.setOnClickListener {
            Toast.makeText(requireContext(), "Сброс", Toast.LENGTH_LONG).show()
        }
        binding.sliderRating.addOnChangeListener { slider, value, fromUser ->
            val toText = value.toString().split(".")[0]
            binding.tvRatingChoose.text = if (toText == "0") "неважно" else "от $toText"
        }

        binding.tvGenreChoose.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .add(R.id.fragment_container, SearchSettingsDetailFragment.newInstance(GENRE_ARGUMENT))
                .addToBackStack(null).commit()
        }
        binding.tvCountryChoose.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .add(R.id.fragment_container, SearchSettingsDetailFragment.newInstance(COUNTRY_ARGUMENT))
                .addToBackStack(null).commit()
        }
    }

    companion object {

        private const val GENRE_ARGUMENT = "genres.name"
        private const val COUNTRY_ARGUMENT = "countries.name"

        fun newInstance(): SearchSettingsFragment {
            return SearchSettingsFragment()
        }
    }
}