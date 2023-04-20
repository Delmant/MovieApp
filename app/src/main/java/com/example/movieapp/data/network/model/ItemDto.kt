package com.example.movieapp.data.network.model

import com.example.movieapp.domain.model.Items
import com.google.gson.annotations.SerializedName

data class ItemDto(
    @SerializedName("items")
    val items: Items
) {
    companion object {
        fun toEntity(itemDto: ItemDto): Items {
            return itemDto.items
        }
    }
}