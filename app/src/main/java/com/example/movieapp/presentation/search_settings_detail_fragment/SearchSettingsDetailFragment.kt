package com.example.movieapp.presentation.search_settings_detail_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.movieapp.databinding.FragmentSearchSettingDetailBinding
import com.example.movieapp.presentation.MovieApp
import com.example.movieapp.presentation.ViewModelFactory
import com.example.movieapp.presentation.adapters.settings_value.SettingsValueAdapter
import javax.inject.Inject

class SearchSettingsDetailFragment : Fragment() {

    private var _binding: FragmentSearchSettingDetailBinding? = null
    private val binding: FragmentSearchSettingDetailBinding
        get() = _binding ?: throw RuntimeException("")

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private var viewModel: SearchSettingsDetailViewModel? = null

    private val component by lazy {
        (requireActivity().application as MovieApp).component
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        component.inject(this)
        viewModel =
            ViewModelProvider(this, viewModelFactory)[SearchSettingsDetailViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchSettingDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.appBar.text.text = "Жанры"
        binding.appBar.ivBack.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
        binding.appBar.tvReset.setOnClickListener {
            Toast.makeText(requireContext(), "Сброс", Toast.LENGTH_LONG).show()
        }
        viewModel?.getSettingsValue()
        viewModel?.liveData?.observe(viewLifecycleOwner) {
            val adapter = SettingsValueAdapter(it)
            binding.rvValue.adapter = adapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        fun newInstance(): SearchSettingsDetailFragment {
            return SearchSettingsDetailFragment()
        }
    }
}