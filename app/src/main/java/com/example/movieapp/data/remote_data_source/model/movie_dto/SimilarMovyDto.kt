package com.example.movieapp.data.remote_data_source.model.movie_dto

import com.example.movieapp.domain.model.movie.SimilarMovies
import com.google.gson.annotations.SerializedName

data class SimilarMovyDto(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("enName")
    val enName: String?,
    @SerializedName("alternativeName")
    val alternativeName: String?,
    @SerializedName("type")
    val type: String?,
    @SerializedName("poster")
    val posterDto: PosterDto?,
) {
    companion object {

        val empty = SimilarMovyDto(-1, "", "", "", "", PosterDto.empty)
        fun toEntity(dto: SimilarMovyDto): SimilarMovies {
            return SimilarMovies(
                id = dto.id ?: -1,
                name = dto.name ?: "",
                enName = dto.enName ?: "",
                alternativeName = dto.alternativeName ?: "",
                type = dto.type ?: "",
                poster = PosterDto.toEntity(dto.posterDto ?: PosterDto("", ""))
            )
        }
    }
}