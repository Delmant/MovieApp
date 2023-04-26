package com.example.movieapp.data.network.model.movie_dto

import com.example.movieapp.domain.model.movie.Fees
import com.example.movieapp.domain.model.movie.Russia
import com.example.movieapp.domain.model.movie.Usa
import com.example.movieapp.domain.model.movie.World
import com.google.gson.annotations.SerializedName

data class FeesDto(
    @SerializedName("world")
    val worldDto: WorldDto?,
    @SerializedName("russia")
    val russiaDto: RussiaDto?,
    @SerializedName("usa")
    val usaDto: UsaDto?,
) {
    companion object {

        val empty = FeesDto(WorldDto.empty, RussiaDto.empty, UsaDto.empty)
        fun toEntity(dto: FeesDto): Fees {
            return Fees(
                world = if(dto.worldDto == null) {
                    World("", -1)
                } else WorldDto.toEntity(dto.worldDto),
                russia = if(dto.russiaDto == null) {
                    Russia("", -1)
                } else RussiaDto.toEntity(dto.russiaDto),
                usa = if(dto.usaDto == null) {
                    Usa("", -1)
                } else UsaDto.toEntity(dto.usaDto)
            )
        }
    }
}