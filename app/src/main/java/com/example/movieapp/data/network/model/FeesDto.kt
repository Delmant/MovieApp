package com.example.movieapp.data.network.model

import com.example.movieapp.domain.model.Fees
import com.google.gson.annotations.SerializedName

data class FeesDto(
    @SerializedName("fees")
    val fees: Fees
) {
    companion object {
        fun toEntity(feesDto: FeesDto): Fees {
            return feesDto.fees
        }
    }
}