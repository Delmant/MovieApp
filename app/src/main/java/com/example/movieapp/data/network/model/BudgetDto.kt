package com.example.movieapp.data.network.model

import com.example.movieapp.domain.model.Budget
import com.google.gson.annotations.SerializedName

data class BudgetDto(
    @SerializedName("value")
    val value: Int?,
    @SerializedName("currency")
    val currency: String?
) {
    companion object {

        val empty = BudgetDto(-1, "")
        fun toEntity(dto: BudgetDto): Budget {
            return Budget(
                value = dto.value ?: -1,
                currency = dto.currency ?: ""
            )
        }
    }
}