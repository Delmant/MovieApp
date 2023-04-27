package com.example.movieapp.presentation.movie_detail_fragment.actor

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.databinding.ActorItemBinding
import com.example.movieapp.domain.model.movie.Persons
import com.example.movieapp.presentation.rv.MovieAdapter

class ActorAdapter(
    val list: List<Persons>,
    val context: Context
) : RecyclerView.Adapter<ActorViewHolder>(){

    var listener: ActorAdapter.OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorViewHolder {
        val binding = ActorItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ActorViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ActorViewHolder, position: Int) {
        val item = list[position]
        with(holder.binding) {
            with(item) {
                Glide.with(context)
                    .load(item.photo)
                    .into(ivMovie)
                tvActorName.text = name.replace(" ", "\n")
            }
            root.setOnClickListener {
                listener?.onItemClick(item.id)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(personId: Int)
    }
}