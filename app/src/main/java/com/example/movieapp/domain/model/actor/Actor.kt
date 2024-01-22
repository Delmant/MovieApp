package com.example.movieapp.domain.model.actor


data class  Actor(
    val age: Int,
    val birthPlace: List<BirthPlace>,
    val birthday: String,
    val countAwards: Int,
    val death: String,
    val deathPlace: List<DeathPlace>,
    val enName: String,
    val actorFacts: List<ActorFact>,
    val growth: Int,
    val id: Int,
    val isParse: Boolean,
    val movies: List<MovieAct>,
    val name: String,
    val photo: String,
    val profession: List<Profession>,
    val sex: String,
//    val spouses: Spouses?,
    val updatedAt: String
)
