package com.example.movieapp.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.movieapp.databinding.FactsItemBinding
import com.example.movieapp.databinding.FragmentFactDetailInfoBinding

class FactDetailFragment: Fragment() {

    private var _binding: FragmentFactDetailInfoBinding? = null
    private val binding: FragmentFactDetailInfoBinding
        get() = _binding ?: throw RuntimeException("")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFactDetailInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val fact = requireArguments().getString(EXTRA_FACT_STRING)
        binding.tvFactDesc.text = fact
        binding.btnClose.setOnClickListener {
            fragmentManager?.popBackStack()
        }
    }

    companion object {

        private const val EXTRA_FACT_STRING = "EXTRA_FACT_STRING"

        fun newInstance(fact: String): FactDetailFragment {
            return FactDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(EXTRA_FACT_STRING, fact)
                }
            }
        }
    }
}