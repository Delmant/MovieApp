package com.example.movieapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.domain.repository.SearchSettingsRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(
    private val searchSettingsRepository: SearchSettingsRepository
): ViewModel() {

    fun clearSearchSettings() {
        viewModelScope.launch {
            searchSettingsRepository.deleteSearchSettings()
        }
    }
}