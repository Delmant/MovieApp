package com.example.movieapp.data.network.model

import com.example.movieapp.domain.model.Fees
import com.example.movieapp.domain.model.Russia
import com.example.movieapp.domain.model.Usa
import com.example.movieapp.domain.model.World
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
        fun toEntity(dto: FeesDto): Fees {
            return Fees(
                world = if(dto.worldDto == null) {World("", -1)} else WorldDto.toEntity(dto.worldDto),
                russia = if(dto.russiaDto == null) {Russia("", -1)} else RussiaDto.toEntity(dto.russiaDto) ,
                usa = if(dto.usaDto == null) {Usa("", -1)} else UsaDto.toEntity(dto.usaDto)
            )
        }
    }
}