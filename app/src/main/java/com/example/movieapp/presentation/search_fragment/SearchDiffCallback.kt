package com.example.movieapp.presentation.search_fragment

import androidx.recyclerview.widget.DiffUtil
import com.example.movieapp.domain.model.movie.Movie

object SearchDiffCallback : DiffUtil.ItemCallback<Movie>() {
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem == newItem
    }
}