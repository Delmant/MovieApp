package com.example.movieapp.data.local_data_source

interface MovieLocalDataSource {

    fun saveSearchSettings(type: String, gson: String)

    fun getSearchSettings()

    fun deleteSearchSettings()
}