package com.example.movieapp.presentation.adapters.review

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.R
import com.example.movieapp.databinding.ReviewItemBinding
import com.example.movieapp.domain.model.review.Review

class ReviewAdapter(
    val list: List<Review>
) : RecyclerView.Adapter<ReviewViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewViewHolder {
        val binding =
            ReviewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ReviewViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int) {
        val item = list[position]
        with(holder.binding) {
            with(item) {
                when (type) {
                    POSITIVE_KEY_WORD -> {
                        container.setBackgroundColor(
                            ContextCompat.getColor(
                                holder.itemView.context,
                                R.color.pale_green
                            )
                        )
                    }

                    NEUTRAL_KEY_WORD -> {
                        container.setBackgroundColor(
                            ContextCompat.getColor(
                                holder.itemView.context,
                                R.color.pale_grey
                            )
                        )
                    }

                    NEGATIVE_KEY_WORD -> {
                        container.setBackgroundColor(
                            ContextCompat.getColor(
                                holder.itemView.context,
                                R.color.pale_red
                            )
                        )
                    }
                }

                tvTitle.text = title
                tvAuthor.text = author
                tvDesc.text = review
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    companion object {
        private const val POSITIVE_KEY_WORD = "Позитивный"
        private const val NEUTRAL_KEY_WORD = "Нейтральный"
        private const val NEGATIVE_KEY_WORD = "Негативный"
    }
}