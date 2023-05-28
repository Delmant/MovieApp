package com.example.movieapp.presentation.search_settings_detail_fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.domain.model.search_settings.SettingsValue
import com.example.movieapp.domain.usecases.GetSettingsValueUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class SearchSettingsDetailViewModel @Inject constructor(
    private val getSettingsValueUseCase: GetSettingsValueUseCase
): ViewModel() {

    private var _liveData = MutableLiveData<List<SettingsValue>>()
    val liveData: LiveData<List<SettingsValue>> = _liveData

    fun getSettingsValue() {
        viewModelScope.launch {
            val settingsValue = getSettingsValueUseCase.invoke("genres.name")
            _liveData.value = settingsValue
        }
    }
}