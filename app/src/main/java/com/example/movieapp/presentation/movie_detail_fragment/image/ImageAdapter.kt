package com.example.movieapp.presentation.movie_detail_fragment.image

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.databinding.ActorItemBinding
import com.example.movieapp.databinding.ImageItemBinding
import com.example.movieapp.domain.model.image.Image
import com.example.movieapp.presentation.movie_detail_fragment.actor.ActorViewHolder

class ImageAdapter(
    val list: List<Image>,
    val context: Context
) : RecyclerView.Adapter<ImageViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val binding = ImageItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ImageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val item = list[position]
        with(holder.binding) {
            with(item) {
                Glide.with(context)
                    .load(item.url)
                    .into(ivImage)

            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }


}