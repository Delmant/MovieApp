package com.example.movieapp.presentation.movie_detail_fragment.actor_detail_fragment

import androidx.lifecycle.ViewModel

class ActorDetailViewModel: ViewModel() {

    fun parseName(name: String): String {
        if(name.isEmpty()) return name
        return name.replace(" ", "\n")
    }
}