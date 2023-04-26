package com.example.movieapp.presentation.movie_detail_fragment.actor_detail_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.movieapp.databinding.FragmentActorDetailInfoBinding
import com.example.movieapp.domain.model.movie.Persons
import java.lang.RuntimeException

class ActorDetailFragment: Fragment() {

    private lateinit var viewModel: ActorDetailViewModel

    var _bindng: FragmentActorDetailInfoBinding? = null
    val binding: FragmentActorDetailInfoBinding
        get() = _bindng ?: throw RuntimeException("")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _bindng = FragmentActorDetailInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args = arguments?.get(EXTRA_PERSON_WORD) as Persons
        Glide.with(this@ActorDetailFragment)
            .load(args.photo)
            .into(binding.ivActor)
        binding.btnClose.setOnClickListener {
            requireFragmentManager().popBackStack()
        }
        viewModel = ViewModelProvider(this)[ActorDetailViewModel::class.java]
        binding.tvActorNameRu.text = viewModel.parseName(args.name)
        binding.tvActorNameEn.text = args.enName
        binding.tvProfession.text = args.profession
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _bindng = null
    }

    companion object {

        private const val EXTRA_PERSON_WORD = "person"

        fun newInstance(persons: Persons): ActorDetailFragment {
            return ActorDetailFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(EXTRA_PERSON_WORD, persons)
                }
            }
        }
    }
}