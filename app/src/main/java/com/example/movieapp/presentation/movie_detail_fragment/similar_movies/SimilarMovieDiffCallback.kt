package com.example.movieapp.presentation.movie_detail_fragment.similar_movies


import androidx.recyclerview.widget.DiffUtil
import com.example.movieapp.domain.model.Movie
import com.example.movieapp.domain.model.SimilarMovies

object SimilarMovieDiffCallback: DiffUtil.ItemCallback<SimilarMovies>() {

    override fun areItemsTheSame(oldItem: SimilarMovies, newItem: SimilarMovies): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: SimilarMovies, newItem: SimilarMovies): Boolean {
        return oldItem == newItem
    }
}