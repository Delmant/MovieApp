package com.example.movieapp.data.network.model

import com.example.movieapp.domain.model.SequelsAndPrequels
import com.google.gson.annotations.SerializedName

data class SequelsAndPrequelDto(
    @SerializedName("sequelsAndPrequels")
    val sequelsAndPrequels: SequelsAndPrequels
) {
    companion object {
        fun toEntity(sequelsAndPrequelDto: SequelsAndPrequelDto): SequelsAndPrequels {
            return sequelsAndPrequelDto.sequelsAndPrequels
        }
    }
}