package com.example.movieapp.presentation.adapters.search

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.example.movieapp.databinding.SearchItemBinding
import com.example.movieapp.domain.model.movie.Movie
import com.example.movieapp.presentation.adapters.movie.MovieDiffCallback

class SearchAdapter(
    val context: Context
) : ListAdapter<Movie, SearchViewHolder>(MovieDiffCallback) {

    var listener: OnItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val binding = SearchItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return SearchViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val item = getItem(position)
        holder.binding.tvSName.text = item.name
        holder.binding.tvSEnName.text = item.enName.ifEmpty { item.alternativeName }
        holder.binding.tvSRating.text = item.rating.kp.toString()
        Glide.with(context)
            .load(item.poster.url)
            .into(holder.binding.ivSPoster)
        holder.binding.root.setOnClickListener {
            listener?.onClick(item.id)
        }


    }

    interface OnItemClick {
        fun onClick(movieId: Int)
    }
}