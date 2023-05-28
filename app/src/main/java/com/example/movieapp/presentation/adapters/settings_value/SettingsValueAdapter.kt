package com.example.movieapp.presentation.adapters.settings_value

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.databinding.SearchSettingDetailItemBinding
import com.example.movieapp.domain.model.search_settings.SettingsValue

class SettingsValueAdapter(
    val list: List<SettingsValue>
) : RecyclerView.Adapter<SettingsValueViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SettingsValueViewHolder {
        val binding = SearchSettingDetailItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return SettingsValueViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: SettingsValueViewHolder, position: Int) {
        val item = list[position]
        holder.binding.tvValueName.text = item.name
    }
}