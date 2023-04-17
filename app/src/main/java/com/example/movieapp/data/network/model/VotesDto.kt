package com.example.movieapp.data.network.model

import com.example.movieapp.domain.model.Votes
import com.google.gson.annotations.SerializedName

data class VotesDto(
    @SerializedName("votes")
    val votes: Votes
)