package com.example.movieapp.presentation.search_settings_detail_fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.movieapp.databinding.FragmentSearchSettingDetailBinding
import com.example.movieapp.domain.model.search_settings.SettingsValue
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
        val arguments = requireArguments().getString(EXTRA_TYPE)
        binding.appBar.text.text = "Жанры"
        binding.appBar.ivBack.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
        viewModel?.getSettingsValue(arguments ?: "")
        viewModel?.liveData?.observe(viewLifecycleOwner) {
            val adapter = SettingsValueAdapter(it)
            binding.rvValue.adapter = adapter
            adapter.listener = object : SettingsValueAdapter.OnClick {
                override fun onClick(list: List<SettingsValue>, position: Int) {
                    list[position].isChoose = true
                }
            }
            binding.appBar.tvReset.setOnClickListener {
                adapter.resetList()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        private const val EXTRA_TYPE = "extra_type"

        fun newInstance(type: String): SearchSettingsDetailFragment {
            return SearchSettingsDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(EXTRA_TYPE, type)
                }
            }
        }
    }
}