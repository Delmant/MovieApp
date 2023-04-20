package com.example.movieapp.data.network.model

import com.example.movieapp.domain.model.ExternalId
import com.google.gson.annotations.SerializedName

data class ExternalIdDto(
    @SerializedName("externalId")
    val externalId: ExternalId
) {
    companion object {
        fun toEntity(externalIdDto: ExternalIdDto): ExternalId {
            return externalIdDto.externalId
        }
    }
}