package com.example.movieapp.data.network.model

import com.example.movieapp.domain.model.Budget
import com.google.gson.annotations.SerializedName

data class BudgetDto(
    @SerializedName("budget")
    val budget: Budget,
) {
    companion object {
        fun toEntity(budgetDto: BudgetDto): Budget {
            return budgetDto.budget
        }
    }
}