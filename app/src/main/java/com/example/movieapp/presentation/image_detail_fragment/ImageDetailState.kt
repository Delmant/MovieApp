package com.example.movieapp.presentation.image_detail_fragment

import com.example.movieapp.domain.model.image.ImageList
import java.lang.Exception

sealed class ImageDetailState {
    object Initial : ImageDetailState()
    object IsLoading : ImageDetailState()

    data class IsError(
        val exception: Exception
    ) : ImageDetailState()

    data class Result(
        val imageList: ImageList
    ) : ImageDetailState()
}