package com.example.movieapp.data.network.model

import com.example.movieapp.domain.model.ReleaseYears
import com.google.gson.annotations.SerializedName

data class ReleaseYearDto(
    @SerializedName("releaseYears")
    val releaseYears: ReleaseYears
) {
    companion object {
        fun toEntity(releaseYearDto: ReleaseYearDto): ReleaseYears {
            return releaseYearDto.releaseYears
        }
    }
}