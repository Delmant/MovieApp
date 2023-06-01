package com.example.movieapp.presentation.adapters.settings_value

import androidx.recyclerview.widget.DiffUtil
import com.example.movieapp.domain.model.search_settings.SettingsValue

class SettingsValueDiffCallback: DiffUtil.ItemCallback<SettingsValue>() {

    override fun areItemsTheSame(oldItem: SettingsValue, newItem: SettingsValue): Boolean {
        return  oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: SettingsValue, newItem: SettingsValue): Boolean {
        return oldItem.isChoose == newItem.isChoose
    }
}