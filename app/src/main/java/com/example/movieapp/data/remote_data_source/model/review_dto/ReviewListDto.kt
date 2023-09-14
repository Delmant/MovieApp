package com.example.movieapp.data.remote_data_source.model.review_dto

import com.google.gson.annotations.SerializedName

data class ReviewListDto(
    @SerializedName("docs")
    val list: List<ReviewDto>,
    @SerializedName("pages")
    val pages: Int
)