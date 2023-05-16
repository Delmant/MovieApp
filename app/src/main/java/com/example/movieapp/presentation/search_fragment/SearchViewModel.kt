package com.example.movieapp.presentation.search_fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.domain.model.movie_list.MovieList
import com.example.movieapp.domain.usecases.GetSearchResultUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class SearchViewModel @Inject constructor(
    val getSearchResultUseCase: GetSearchResultUseCase
) : ViewModel() {

    private val _searchLiveData = MutableLiveData<MovieList>()
    val searchLiveData: LiveData<MovieList> = _searchLiveData

    fun getSearchResult(name: String) {
        viewModelScope.launch {
            val movieResult = getSearchResultUseCase.invoke(name)
            _searchLiveData.value = movieResult
        }
    }
}