package com.example.movieapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.domain.usecases.DeleteSharedPrefSearchSettingsUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(
    private val deleteSharedPrefSearchSettingsUseCase: DeleteSharedPrefSearchSettingsUseCase
): ViewModel() {

    fun clearSearchSettings() {
        viewModelScope.launch {
            deleteSharedPrefSearchSettingsUseCase.invoke()
        }
    }
}