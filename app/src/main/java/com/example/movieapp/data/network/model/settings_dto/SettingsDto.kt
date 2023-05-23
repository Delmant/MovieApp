package com.example.movieapp.data.network.model.settings_dto

data class SettingsDto(
    val country: List<SettingsValueDto>,
    val genre: List<SettingsValueDto>,
    val year: List<String>,
    val rating: String
)