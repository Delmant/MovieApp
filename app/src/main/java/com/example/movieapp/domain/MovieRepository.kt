package com.example.movieapp.domain

interface MovieRepository {

    fun getMovieById()

    fun getRandomMovie()

    fun getMovie()

    fun loadData()
}