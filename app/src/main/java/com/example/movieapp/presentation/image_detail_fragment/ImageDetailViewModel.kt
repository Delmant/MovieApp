package com.example.movieapp.presentation.image_detail_fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.domain.model.image.ImageList
import com.example.movieapp.domain.reaction.Reaction
import com.example.movieapp.domain.usecases.GetImageByMovieIdUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ImageDetailViewModel @Inject constructor(
    private val getImageByMovieIdUseCase: GetImageByMovieIdUseCase
) : ViewModel() {

    private val _state = MutableLiveData<ImageDetailState>(ImageDetailState.Initial)
    val state = _state

    fun getMovieById(id: Int) {
        viewModelScope.launch {
            val reaction: Reaction<ImageList> = getImageByMovieIdUseCase.invoke(id)
            when (reaction) {
                is Reaction.Success -> {
                    _state.value = ImageDetailState.Result(
                        imageList = reaction.data
                    )
                }

                is Reaction.Error -> {
                    _state.value = ImageDetailState.IsError(
                        exception = reaction.exception
                    )
                }
            }

        }
    }
}