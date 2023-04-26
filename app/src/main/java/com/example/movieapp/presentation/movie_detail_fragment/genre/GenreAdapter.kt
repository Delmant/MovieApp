package com.example.movieapp.presentation.movie_detail_fragment.genre

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.databinding.GenreItemBinding
import com.example.movieapp.domain.model.movie.Genres

class GenreAdapter(
    private val items: List<Genres>
    ): RecyclerView.Adapter<GenreViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreViewHolder {
        val binding = GenreItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GenreViewHolder((binding))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: GenreViewHolder, position: Int) {
       val item = items[position]
        with(holder.binding) {
            with(item) {

            }
        }
    }
}