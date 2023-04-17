package com.example.movieapp.data.network.model

import com.example.movieapp.domain.model.ProductionCompanies
import com.google.gson.annotations.SerializedName

data class ProductionCompanyDto(
    @SerializedName("productionCompanies")
    val productionCompanies: ProductionCompanies
)