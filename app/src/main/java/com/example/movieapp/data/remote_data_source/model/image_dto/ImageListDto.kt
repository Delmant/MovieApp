package com.example.movieapp.data.remote_data_source.model.image_dto

import com.google.gson.annotations.SerializedName

data class ImageListDto(
    @SerializedName("docs")
    val imageList: List<ImageDto>
)