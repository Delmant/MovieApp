package com.example.movieapp.data.network.model.review_dto

import com.google.gson.annotations.SerializedName

data class ReviewListDto(
    @SerializedName("docs")
    val list: List<ReviewDto>
)