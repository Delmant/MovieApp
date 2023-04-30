package com.example.movieapp.presentation.image_detail_fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.domain.model.image.ImageList
import com.example.movieapp.domain.usecases.GetImageByMovieIdUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class ImageDetailViewModel @Inject constructor(
    private val getImageByMovieIdUseCase: GetImageByMovieIdUseCase
) : ViewModel() {

    private val _movieLiveDataImages = MutableLiveData<ImageList>()
    val movieLiveDataImages: LiveData<ImageList> = _movieLiveDataImages

    fun getMovieById(id: Int) {
        viewModelScope.launch {
            val image = getImageByMovieIdUseCase.invoke(id)
            _movieLiveDataImages.value = image

        }
    }
}