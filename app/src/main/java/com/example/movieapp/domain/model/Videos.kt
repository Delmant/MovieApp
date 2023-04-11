package com.example.movieapp.domain.model

import com.example.movieapp.domain.model.Teaser
import com.example.movieapp.domain.model.Trailer

data class Videos(
    val teasers: List<Teaser>,
    val trailers: List<Trailer>
)