package com.example.movieapp.data.local_data_source

interface MovieLocalDataSource {

    fun saveSearchSettings()

    fun getSearchSettings()

    fun deleteSearchSettings()
}