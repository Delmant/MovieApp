package com.example.movieapp.presentation.actor_detail_fragment

import com.example.movieapp.domain.model.actor.Actor
import java.lang.Exception

sealed class ActorDetailState {
    object Initial : ActorDetailState()
    object IsLoading : ActorDetailState()

    data class IsError(
        val exception: Exception
    ): ActorDetailState()
    data class Result(
        val actor: Actor
    ) : ActorDetailState()
}