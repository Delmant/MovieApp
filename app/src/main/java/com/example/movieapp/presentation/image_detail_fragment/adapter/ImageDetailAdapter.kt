package com.example.movieapp.presentation.image_detail_fragment.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.databinding.ImageDetailItemBinding
import com.example.movieapp.databinding.ImageItemBinding
import com.example.movieapp.domain.model.image.Image
import com.example.movieapp.presentation.adapters.image.ImageViewHolder

class ImageDetailAdapter(
    val list: List<Image>,
    val context: Context
) : RecyclerView.Adapter<ImageDetailViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageDetailViewHolder {
        val binding = ImageDetailItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ImageDetailViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ImageDetailViewHolder, position: Int) {
        val item = list[position]
        with(holder.binding) {
            with(item) {
                Glide.with(context)
                    .load(item.url)
                    .into(ivImageDetail)

            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface OnItemClickListener {
        fun onClick(movieId: Int)
    }

}