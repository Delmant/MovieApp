package com.example.movieapp.data.network.model

import com.example.movieapp.domain.model.Teasers
import com.google.gson.annotations.SerializedName

data class TeaserDto(
    @SerializedName("teasers")
    val teasers: Teasers
) {
    companion object {

        fun toEntity(teaserDto: TeaserDto): Teasers {
            return teaserDto.teasers
        }
    }
}