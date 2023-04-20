package com.example.movieapp.data.network.model

import com.google.gson.annotations.SerializedName

data class WatchabilityDto(
    @SerializedName("items")
    val itemDtos: List<ItemDto>
)