package com.example.movieapp.data.network.model

import com.example.movieapp.domain.model.ReleaseYears
import com.google.gson.annotations.SerializedName

data class ReleaseYearDto(
    @SerializedName("start")
    val start: Int?,
    @SerializedName("end")
    val end: Int?
) {
    companion object {

        val empty = ReleaseYearDto(-1, -1)
        fun toEntity(dto: ReleaseYearDto): ReleaseYears {
            return ReleaseYears(
                start = dto.start ?: -1,
                end = dto.end ?: -1
            )
        }
    }
}