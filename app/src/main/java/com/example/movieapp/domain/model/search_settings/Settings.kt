package com.example.movieapp.domain.model.search_settings

data class Settings(
    val country: List<SettingsValue>,
    val genre: List<SettingsValue>,
    val year: List<String>,
    val rating: String
) {
}