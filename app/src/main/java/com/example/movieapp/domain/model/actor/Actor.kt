package com.example.movieapp.domain.model.actor

data class Actor(
    val age: Int,
    val birthPlace: List<BirthPlace>,
    val birthday: String,
    val countAwards: Int,
    val death: String,
    val deathPlace: String,
    val enName: String,
    val facts: List<Fact>,
    val growth: Int,
    val id: Int,
    val isParse: Boolean,
    val movies: List<MovieAct>,
    val name: String,
    val photo: String,
    val profession: List<Profession>,
    val sex: String,
    val spouses: List<String>,
    val updatedAt: String
)
