package com.example.movieapp.domain.model.actor

data class Spouses (
    val id: Int,
    val name: String,
    val divorced: Boolean,
    val divorcedReason: String?,
    val sex: String,
    val children: Int,
    val relation: String
)