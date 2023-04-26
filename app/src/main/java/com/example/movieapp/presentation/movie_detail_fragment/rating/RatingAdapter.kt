package com.example.movieapp.presentation.movie_detail_fragment.rating

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.databinding.RatingNoVotesItemBinding
import com.example.movieapp.databinding.RatingVotesItemBinding
import java.lang.RuntimeException

class RatingAdapter(val list: List<Pair<String, Pair<String, String>>>) :
    RecyclerView.Adapter<RatingViewHolder<*>>() {

    override fun getItemViewType(position: Int): Int {
        return if (list[position].second.second.isEmpty()) return TYPE_HAS_NO_VOTES else TYPE_HAS_VOTES
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RatingViewHolder<*> {
        return when (viewType) {
            TYPE_HAS_VOTES -> {
                val binding = RatingVotesItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return RatingViewHolder(binding)
            }
            TYPE_HAS_NO_VOTES -> {
                val binding = RatingNoVotesItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return RatingViewHolder(binding)
            }
            else -> throw RuntimeException("")
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RatingViewHolder<*>, position: Int) {
        holder.bind(list[position])
    }

    companion object {
        private const val TYPE_HAS_VOTES = 1
        private const val TYPE_HAS_NO_VOTES = 2
    }
}