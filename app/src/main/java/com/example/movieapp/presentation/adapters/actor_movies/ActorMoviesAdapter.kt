package com.example.movieapp.presentation.adapters.actor_movies


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.example.movieapp.databinding.ActorMoviesItemBinding
import com.example.movieapp.domain.model.actor.MovieAct


class ActorMoviesAdapter(
    val list: List<MovieAct>
) : RecyclerView.Adapter<ActorMoviesViewHolder>() {

    var listener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorMoviesViewHolder {
        val binding =
            ActorMoviesItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ActorMoviesViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ActorMoviesViewHolder, position: Int) {
        val item = list[position]
        with(holder.binding) {
            tvMovieName.text = item.name
            tvActorRole.text = item.description
            tvMovieRating.text = item.rating.toString()
            root.setOnClickListener {
                listener?.onItemClick(item.id)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(movieId: Int)
    }
}