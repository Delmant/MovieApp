package com.example.movieapp.presentation.movie_detail_fragment.fact

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.databinding.FactsItemBinding
import com.example.movieapp.domain.model.movie.Facts


class FactAdapter(
    private val items: List<Facts>
) : RecyclerView.Adapter<FactViewHolder>() {


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
        }
    }
}