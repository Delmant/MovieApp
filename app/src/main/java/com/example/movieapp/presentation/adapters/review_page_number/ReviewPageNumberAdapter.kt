package com.example.movieapp.presentation.adapters.review_page_number

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.R
import com.example.movieapp.databinding.PageNumberItemBinding

class ReviewPageNumberAdapter(
    val list: List<Int>
) : RecyclerView.Adapter<ReviewPageNumberViewHolder>() {

    var listener: OnItemClickListener? = null

    private var selectedPosition = RecyclerView.NO_POSITION
    private var selectedViewHolder: ReviewPageNumberViewHolder? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewPageNumberViewHolder {
        val binding =
            PageNumberItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ReviewPageNumberViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ReviewPageNumberViewHolder, position: Int) {
        val item = list[position]
        holder.binding.tvPageNumber.text = item.toString()

        if (position == selectedPosition) {
            holder.binding.tvPageNumber.background =
                ContextCompat.getDrawable(holder.itemView.context, R.drawable.tv_gradient)
            selectedViewHolder = holder
        } else {
            holder.binding.tvPageNumber.background =
                ContextCompat.getDrawable(holder.itemView.context, R.drawable.tv_gradient_dark)
        }

        holder.binding.root.setOnClickListener {
            listener?.onClick(item)
            if (selectedPosition != position) {
                selectedViewHolder?.binding?.tvPageNumber?.background =
                    ContextCompat.getDrawable(holder.itemView.context, R.drawable.tv_gradient_dark)

                holder.binding.tvPageNumber.background = ContextCompat.getDrawable(holder.itemView.context, R.drawable.tv_gradient)
                selectedViewHolder = holder
                selectedPosition = position
            }
        }
    }

    interface OnItemClickListener {
        fun onClick(page: Int)
    }
}

