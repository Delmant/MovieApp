package com.example.movieapp.presentation.rv

import Movie
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.example.movieapp.data.network.model.MovieDto
import com.example.movieapp.databinding.MovieItemBinding

class MovieAdapter(
    private val context: Context
) : ListAdapter<MovieDto, MovieViewHolder >(MovieDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = MovieItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = getItem(position)
        with(holder.binding) {
            with(movie) {
                Glide.with(context)
                    .load("https://st.kp.yandex.net/images/film_big/${movie.id}.jpg")
                    .into(ivMovie)
            }
        }
    }
}