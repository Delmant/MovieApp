package com.example.movieapp.presentation.movie_detail_fragment.similar_movies

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.example.movieapp.databinding.MovieItemBinding
import com.example.movieapp.domain.model.movie.SimilarMovies


class SimilarMovieAdapter(
    private val context: Context
) : ListAdapter<SimilarMovies, SimilarMovieViewHolder >(SimilarMovieDiffCallback) {

    var listener: OnItemClickListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimilarMovieViewHolder {
        val binding = MovieItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        binding.root.setOnClickListener {  }
        return SimilarMovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SimilarMovieViewHolder, position: Int) {
        val movie = getItem(position)
        with(holder.binding) {
            with(movie) {
                Glide.with(context)
                    .load("https://st.kp.yandex.net/images/film_big/${movie.id}.jpg")
                    .into(ivMovie)
                tvMovieName.text = movie.name
                tvType.text = movie.type
            }
            root.setOnClickListener {
                listener?.onItemClick(movie)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(data: SimilarMovies)
    }
}