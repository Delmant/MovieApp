package com.example.movieapp.domain.repository

interface SearchSettingsRepository {

    fun saveSearchSettings(type: String, gson: String)

    fun getSearchSettings()

    fun deleteSearchSettings()
}