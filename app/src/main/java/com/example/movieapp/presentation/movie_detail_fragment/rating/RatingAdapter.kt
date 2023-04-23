package com.example.movieapp.presentation.movie_detail_fragment.rating

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.databinding.RatingItemBinding

class RatingAdapter(val list: List<String>): RecyclerView.Adapter<RatingViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RatingViewHolder {
        val binding = RatingItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RatingViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RatingViewHolder, position: Int) {
        val item = list[position]
        with(holder.binding) {
            with(item) {

            }
        }
    }
}