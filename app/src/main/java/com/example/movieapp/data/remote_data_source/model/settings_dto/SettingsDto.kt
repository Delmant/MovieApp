package com.example.movieapp.data.remote_data_source.model.settings_dto

data class SettingsDto(
    val country: List<SettingsValueDto>,
    val genre: List<SettingsValueDto>,
    val year: List<String>,
    val rating: String
)