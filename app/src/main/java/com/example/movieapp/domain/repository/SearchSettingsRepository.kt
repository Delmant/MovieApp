package com.example.movieapp.domain.repository

interface SearchSettingsRepository {

    fun saveSearchSettings()

    fun getSearchSettings()

    fun deleteSearchSettings()
}