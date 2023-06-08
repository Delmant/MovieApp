package com.example.movieapp.data.repository_impl

import android.app.Application
import android.content.Context
import android.util.Log
import com.example.movieapp.domain.model.search_settings.Settings
import com.example.movieapp.domain.model.search_settings.SettingsValue
import com.example.movieapp.domain.repository.SearchSettingsRepository
import com.google.gson.Gson
import javax.inject.Inject

class SearchSettingsRepositoryImpl @Inject constructor(
    val application: Application
) : SearchSettingsRepository {

    private val sharedPreferences = application.getSharedPreferences(SHARED_PREFERENCES_KEY_WORD, Context.MODE_PRIVATE)
    private val sharedPreferencesEdit = sharedPreferences.edit()

    private val gson = Gson()

    override fun saveSearchSettings(type: String, gson: String) {
        sharedPreferencesEdit.putString(type, gson)
        sharedPreferencesEdit.apply()
    }

    override fun getSearchSettings() {
        val genre = sharedPreferences.getString(GENRE_KEY_WORD, "")
        val country = sharedPreferences.getString(COUNTRY_KEY_WORD, "")
        val year = sharedPreferences.getString(YEAR_KEY_WORD, "")
        val rating = sharedPreferences.getString(RATING_KEY_WORD, "")

        Log.d("SHAREDVALUE", genre.toString())
        Log.d("SHAREDVALUE", country.toString())
        Log.d("SHAREDVALUE", year.toString())
        Log.d("SHAREDVALUE", rating.toString())
    }

    override fun deleteSearchSettings() {
        sharedPreferencesEdit.clear().apply()
    }

    companion object {

        private const val SHARED_PREFERENCES_KEY_WORD = "SHARED_PREFERENCES_KEY_WORD"

        private const val GENRE_KEY_WORD = "genres.name"
        private const val COUNTRY_KEY_WORD = "countries.name"
        private const val YEAR_KEY_WORD = "year"
        private const val RATING_KEY_WORD = "rating"
    }
}