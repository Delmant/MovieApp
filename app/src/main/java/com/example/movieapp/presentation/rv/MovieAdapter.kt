package com.example.movieapp.presentation.rv

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.example.movieapp.databinding.MovieItemBinding
import com.example.movieapp.domain.model.movie.Movie


class MovieAdapter(
    private val context: Context
) : ListAdapter<Movie, MovieViewHolder >(MovieDiffCallback) {

    var listener: OnItemClickListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = MovieItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        binding.root.setOnClickListener {  }
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = getItem(position)
        with(holder.binding) {
            with(movie) {
                Glide.with(context)
                    .load("https://st.kp.yandex.net/images/film_big/${movie.id}.jpg")
                    .into(ivMovie)
                tvMovieName.text = movie.name
            }
            root.setOnClickListener {
                listener?.onItemClick(movie.id)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(movieId: Int)
    }
}