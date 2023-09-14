package com.example.movieapp.data.remote_data_source.model.movie_dto

import com.example.movieapp.domain.model.movie.ReleaseYears
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