package com.example.movieapp.presentation.adapters.review_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.R
import com.example.movieapp.databinding.ReviewMiniListItemBinding
import com.example.movieapp.domain.model.review.Review
import com.example.movieapp.presentation.adapters.review_mini.ReviewMiniAdapter

class ReviewListAdapter(
    val movieId: Int,
    val list: List<Review>
) : RecyclerView.Adapter<ReviewListViewHolder>() {

    var listener: ReviewMiniAdapter.OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewListViewHolder {
        val binding = ReviewMiniListItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ReviewListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ReviewListViewHolder, position: Int) {
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

                tvAuthor.text = author
                tvMiniDesc.text = review
            }
            root.setOnClickListener {
                listener?.onClick(movieId)
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface OnItemClickListener {
        fun onClick(movieId: Int)
    }

    companion object {
        private const val POSITIVE_KEY_WORD = "Позитивный"
        private const val NEUTRAL_KEY_WORD = "Нейтральный"
        private const val NEGATIVE_KEY_WORD = "Негативный"

    }
}