package com.example.movieapp.presentation.search_setting_fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.domain.usecases.GetSharedPrefSearchSettingsUseCase
import com.example.movieapp.domain.usecases.SaveSharedPrefSearchSettingsUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class SearchSettingsViewModel @Inject constructor(
    private val saveSharedPrefSearchSettingsUseCase: SaveSharedPrefSearchSettingsUseCase,
    private val getSharedPrefSearchSettingsUseCase: GetSharedPrefSearchSettingsUseCase
) : ViewModel() {

    fun saveSearchSettings(type: String, json: String) {
        viewModelScope.launch {
            saveSharedPrefSearchSettingsUseCase.invoke(type, json)
        }
    }

    fun getSearchSettings() {
        viewModelScope.launch {
            getSharedPrefSearchSettingsUseCase.invoke()
        }
    }
}