package com.example.movieapp.domain.model.actor

import com.example.movieapp.domain.model.movie.Facts

data class ActorFact (
    val value: String
) {
    companion object {
        fun toFacts(actorFact: ActorFact): Facts {
            return Facts(
                spoiler = false,
                value = actorFact.value,
                type = ""
            )
        }
    }
}