package com.example.movieapp.domain.model.actor

data class MovieAct (
    val description: String,
    val general: Boolean,
    val id: Int,
    val name: String,
    val alternativeName: String?,
    val rating: Double
)