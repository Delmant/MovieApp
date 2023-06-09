package com.example.movieapp.presentation.adapters.image

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.databinding.ActorItemBinding
import com.example.movieapp.databinding.ImageItemBinding
import com.example.movieapp.domain.model.image.Image
import com.example.movieapp.presentation.adapters.actor.ActorViewHolder

class ImageAdapter(
    val movieId: Int,
    val list: List<Image>,
    val context: Context
) : RecyclerView.Adapter<ImageViewHolder>() {

    var listener: OnItemClickListener? = null

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
            root.setOnClickListener {
                listener?.onClick(movieId, position)
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface OnItemClickListener {
        fun onClick(movieId: Int, position: Int)
    }

}