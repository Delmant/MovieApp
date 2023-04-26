package com.example.movieapp.presentation.movie_detail_fragment.rating

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.movieapp.databinding.RatingNoVotesItemBinding
import com.example.movieapp.databinding.RatingVotesItemBinding

class RatingViewHolder<T : ViewBinding>(val binding: T) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Pair<String, Pair<String, String>>) {
        when (binding) {
            is RatingVotesItemBinding -> {
                val typedBinding = binding as RatingVotesItemBinding
                typedBinding.tvVotes.text = item.second.second
                typedBinding.tvRating.text = item.second.first
                typedBinding.tvNameRate.text = item.first
            }
            is RatingNoVotesItemBinding -> {
                val typedBinding = binding as RatingNoVotesItemBinding
                typedBinding.tvRating.text = item.second.first
                typedBinding.tvNameRate.text = item.first
            }
            else -> throw IllegalArgumentException("Unknown item type")
        }
    }

    companion object {
        private const val TYPE_HAS_VOTES = 1
        private const val TYPE_HAS_NO_VOTES = 2
    }
}