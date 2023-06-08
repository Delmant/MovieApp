package com.example.movieapp.presentation.search_settings_detail_fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.domain.model.search_settings.SettingsValue
import com.example.movieapp.domain.repository.SearchSettingsRepository
import com.example.movieapp.domain.usecases.GetSettingsValueUseCase
import com.google.gson.Gson
import kotlinx.coroutines.launch
import javax.inject.Inject

class SearchSettingsDetailViewModel @Inject constructor(
    private val getSettingsValueUseCase: GetSettingsValueUseCase,
    private val searchSettingsRepository: SearchSettingsRepository
) : ViewModel() {

    private val gson = Gson()
    private var _liveData = MutableLiveData<List<SettingsValue>>()
    val liveData: LiveData<List<SettingsValue>> = _liveData

    fun getSettingsValue(type: String) {
        viewModelScope.launch {
            val settingsValue = getSettingsValueUseCase.invoke(type)
            _liveData.value = settingsValue
        }
    }

    fun saveSettings(type: String, list2: List<SettingsValue>) {
        viewModelScope.launch {
            searchSettingsRepository.saveSearchSettings(type, gson.toJson(list2))
        }
    }
}