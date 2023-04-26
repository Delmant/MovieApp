package com.example.movieapp.data.network.model.movie_dto

import com.example.movieapp.domain.model.movie.SequelsAndPrequels
import com.google.gson.annotations.SerializedName

data class SequelsAndPrequelDto(
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
    val posterDto: PosterDto?
) {
    companion object {
        val empty = SequelsAndPrequelDto(-1, "", "", "", "", PosterDto.empty)
        fun toEntity(dto: SequelsAndPrequelDto): SequelsAndPrequels {
            return SequelsAndPrequels(
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