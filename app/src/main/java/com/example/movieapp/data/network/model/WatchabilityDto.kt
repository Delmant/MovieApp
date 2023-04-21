package com.example.movieapp.data.network.model

import com.example.movieapp.domain.model.Watchability
import com.google.gson.annotations.SerializedName

data class WatchabilityDto(
    @SerializedName("items")
    val itemDtos: List<ItemDto>
) {
    companion object {
        fun toEntity(dto: WatchabilityDto): Watchability {
            return Watchability(
                dto.itemDtos.map {
                    ItemDto.toEntity(it)
                }
            )
        }
    }
}