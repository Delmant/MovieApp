package com.example.movieapp.presentation.adapters.review_mini

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.R
import com.example.movieapp.databinding.ReviewMiniItemBinding
import com.example.movieapp.domain.model.review.Review

class ReviewMiniAdapter(
    val movieId: Int,
    val list: List<Review>
) : RecyclerView.Adapter<ReviewMiniViewHolder>() {

    var listener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewMiniViewHolder {
        val binding =
            ReviewMiniItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ReviewMiniViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ReviewMiniViewHolder, position: Int) {
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