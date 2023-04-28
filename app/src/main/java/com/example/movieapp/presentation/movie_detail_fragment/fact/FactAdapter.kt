package com.example.movieapp.presentation.movie_detail_fragment.fact

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.databinding.FactsItemBinding
import com.example.movieapp.domain.model.movie.Facts
import com.example.movieapp.presentation.movie_detail_fragment.actor.ActorAdapter


class FactAdapter(
    private val items: List<Facts>
) : RecyclerView.Adapter<FactViewHolder>() {

    var listener: FactAdapter.OnItemClickListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FactViewHolder {
        val binding = FactsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FactViewHolder((binding))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: FactViewHolder, position: Int) {
        val item = items[position]
        with(holder.binding) {
            with(item) {
                tvDesc.text = item.value
            }
            root.setOnClickListener {
                listener?.onItemClick(item.value)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(fact: String)
    }
}