package com.example.movieapp.domain.reaction

import java.lang.Exception

sealed class Reaction<out T> {
   data class Error(val exception: Exception): Reaction<Nothing>()

    data class Success<T>(val data: T): Reaction<T>()
}
