package com.example.movieapp.presentation.search_setting_fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.domain.repository.SearchSettingsRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class SearchSettingsViewModel @Inject constructor(
    private val searchSettingsRepository: SearchSettingsRepository
) : ViewModel() {

    fun saveSearchSettings(type: String, json: String) {
        viewModelScope.launch {
            searchSettingsRepository.saveSearchSettings(type, json)
        }
    }

    fun getSearchSettings() {
        viewModelScope.launch {
            searchSettingsRepository.getSearchSettings()
        }
    }
}