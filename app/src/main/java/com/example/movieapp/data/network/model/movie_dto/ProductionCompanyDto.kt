package com.example.movieapp.data.network.model.movie_dto

import com.example.movieapp.domain.model.movie.ProductionCompanies
import com.google.gson.annotations.SerializedName

data class ProductionCompanyDto(
    @SerializedName("name")
    val name: String?,
    @SerializedName("url")
    val url: String?,
    @SerializedName("previewUrl")
    val previewUrl: String?
) {
    companion object {

        val empty = ProductionCompanyDto("", "", "")
        fun toEntity(dto: ProductionCompanyDto): ProductionCompanies {
            return ProductionCompanies(
                name = dto.name ?: "",
                url = dto.url ?: "",
                previewUrl = dto.previewUrl ?: ""
            )
        }
    }
}